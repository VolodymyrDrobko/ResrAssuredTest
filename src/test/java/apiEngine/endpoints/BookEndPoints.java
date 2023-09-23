package apiEngine.endpoints;

import apiEngine.model.request.AddBooksRequest;
import apiEngine.model.request.RemoveBookRequest;
import apiEngine.model.response.*;
import apiEngine.route.Route;
import io.restassured.response.Response;

public class BookEndPoints extends EndPoints {

    public IResponse<Books> getBooks() {
        Response response = initRequest().get(Route.getBooks());
        response.body().prettyPrint();
        return new ResponseManager<>(Books.class, response);
    }

    public IResponse<UserAccount> addBook(AddBooksRequest addBooksRequest, Token token) {
        Response response = initRequestAuthenticate(token).body(addBooksRequest).post(Route.getBooks());
        response.body().prettyPrint();

        return new ResponseManager<>(UserAccount.class, response);
    }

    public IResponse<RemoveBook> deleteBookByIsbn(RemoveBookRequest removeBookRequest, Token token) {
        Response response = initRequestAuthenticate(token).body(removeBookRequest).delete(Route.getBook());
        response.prettyPrint();
        return new ResponseManager<>(RemoveBook.class, response);
    }

    public IResponse<UserAccount> getAccountBooks(String USER_ID, Token token) {
        Response response = initRequestAuthenticate(token).get(Route.getAccountUser(USER_ID));
        response.prettyPrint();
        return new ResponseManager<>(UserAccount.class, response);
    }
}
