package apiEngine.model.response;

import io.restassured.response.Response;

public interface IResponse<T> {
    T getBody();

    String getContent();

    int getStatusCode();

    boolean isSuccessful();

    String getStatusLine();

    Response getResponse();

    Exception getException();
}
