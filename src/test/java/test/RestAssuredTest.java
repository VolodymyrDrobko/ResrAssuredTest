package test;

import apiEngine.model.Book;
import apiEngine.model.response.Books;
import apiEngine.model.response.Token;
import apiEngine.steps.AccountSteps;
import apiEngine.steps.BookSteps;
import org.testng.annotations.Test;

import java.util.List;

public class RestAssuredTest {

    @Test
    public void endToEndTest() {
        AccountSteps accountSteps = new AccountSteps();
        BookSteps bookSteps = new BookSteps();

        String userName = "user31859";
        String password = "User31851@gmail.com";

        accountSteps.registerUser(userName, password);
        String userId = accountSteps.getUserId();
        accountSteps.generateToken(userName, password);
        Token token = accountSteps.getToken();
        Books booksModel = bookSteps.getBooks();
        bookSteps.isBooksListNotEmpty(booksModel);
        Book bookToAdd = booksModel.books.get(0);
        bookSteps.addBook(userId, bookToAdd, token);
        List<Book> bookList = bookSteps.getAccountBooks(userId, token);
        bookSteps.isBookAddedForUser(bookList, bookToAdd.getIsbn());
        bookSteps.deleteBookByIsbn(bookToAdd.getIsbn(), userId, token);

        bookList = bookSteps.getAccountBooks(userId, token);
        bookSteps.isBookRemovedForAccount(bookList, bookToAdd);
    }

    @Test
    public void test() {
        AccountSteps accountSteps = new AccountSteps();
        String userName = "user31859";
        String password = "User31852@gmail.com";
        BookSteps bookSteps = new BookSteps();

        String userId = "6243e55d-8a75-4ea9-9110-80583ebd6336";

        accountSteps.generateToken(userName, password);
        Token token = accountSteps.getToken();

        List<Book> bookList = bookSteps.getAccountBooks(userId, token);

        System.out.println(bookList);
    }
}
