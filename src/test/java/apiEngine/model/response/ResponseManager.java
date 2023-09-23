package apiEngine.model.response;

import io.restassured.response.Response;

public class ResponseManager<T> implements IResponse<T> {
    private T data;
    private final Response response;
    private final int statusCode;
    private Exception e;

    public ResponseManager(Class<T> t, Response response) {
        this.response = response;
        this.statusCode = response.getStatusCode();
        try {
            this.data = t.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("There must be default constructor in Response POJO class");
        }
    }

    @Override
    public T getBody() {
        try {
            data = (T) response.getBody().as(data.getClass());
        } catch (Exception e) {
            this.e = e;
        }
        return data;
    }

    @Override
    public String getContent() {
        return response.getBody().asString();
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public boolean isSuccessful() {
        if (String.valueOf(statusCode).startsWith("2"))
            return true;
        else
            return false;
    }

    @Override
    public String getStatusLine() {
        return response.getStatusLine();
    }

    @Override
    public Response getResponse() {
        return response;
    }

    @Override
    public Exception getException() {
        return e;
    }
}
