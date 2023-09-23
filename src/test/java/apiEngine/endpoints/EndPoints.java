package apiEngine.endpoints;

import apiEngine.model.response.Token;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class EndPoints {
    public static final String BASE_URL = "https://demoqa.com";

    protected RequestSpecification initRequest() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        return request;
    }

    protected RequestSpecification initRequestAuthenticate(Token token) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + token.token);
        return request;
    }
}
