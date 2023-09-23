package apiEngine.steps;

import apiEngine.endpoints.BookEndPoints;
import apiEngine.model.Book;
import apiEngine.model.ISBN;
import apiEngine.model.request.AddBooksRequest;
import apiEngine.model.request.RemoveBookRequest;
import apiEngine.model.response.*;
import org.apache.http.HttpStatus;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BookSteps {
    private final BookEndPoints endPoints = new BookEndPoints();

    public Books getBooks() {
        IResponse<Books> booksIResponse = endPoints.getBooks();
        Assert.assertEquals(booksIResponse.getStatusCode(), HttpStatus.SC_OK);
        return booksIResponse.getBody();
    }

    public void isBooksListNotEmpty(Books booksModel) {
        Assert.assertTrue(booksModel.books.size() > 0, "Book list is - NOT EMPTY: " + booksModel.books);
    }

    public void addBook(String userId, Book bookModel, Token token) {
        List<ISBN> collectionOfIsbns = new ArrayList<>();
        collectionOfIsbns.add(new ISBN(bookModel.getIsbn()));

        AddBooksRequest addBooksRequest = new AddBooksRequest(userId, collectionOfIsbns);
        IResponse<UserAccount> userAccountIResponse = endPoints.addBook(addBooksRequest, token);
        Assert.assertEquals(userAccountIResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }

    public List<Book> getAccountBooks(String userId, Token token) {
        IResponse<UserAccount> userAccountIResponse = endPoints.getAccountBooks(userId, token);
        Assert.assertEquals(userAccountIResponse.getStatusCode(), HttpStatus.SC_OK);
        return userAccountIResponse.getBody().books;
    }

    public void isBookAddedForUser(List<Book> books, String isbn) {
        Assert.assertEquals(books.get(0).getIsbn(), isbn);
    }

    public void deleteBookByIsbn(String isbn, String userId, Token token) {
        RemoveBookRequest removeBookRequest = new RemoveBookRequest(isbn, userId);
        IResponse<RemoveBook> removeBookIResponse = endPoints.deleteBookByIsbn(removeBookRequest, token);
        Assert.assertEquals(removeBookIResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }

    public void isBookRemovedForAccount(List<Book> books, Book bookModel) {
        Assert.assertEquals(0, books.size());
        Assert.assertFalse(books.contains(bookModel));
    }
}
