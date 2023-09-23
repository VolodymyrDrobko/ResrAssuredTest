package apiEngine.endpoints;

import apiEngine.endpoints.EndPoints;
import apiEngine.model.request.AddBooksRequest;
import apiEngine.model.request.AuthorizationRequest;
import apiEngine.model.request.RemoveBookRequest;
import apiEngine.model.response.*;
import apiEngine.route.Route;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

public class AccountEndPoints extends EndPoints {

    public IResponse<RegisteredUser> registerUser(AuthorizationRequest authorizationRequest) {
        Response response = initRequest().body(authorizationRequest).post(Route.registerUser());

        response.body().prettyPrint();

        return new ResponseManager<>(RegisteredUser.class, response);
    }

    public IResponse<Token> generateToken(AuthorizationRequest authorizationRequest) {
        Response response = initRequest().body(authorizationRequest).post(Route.generateToken());

        if (response.statusCode() != HttpStatus.SC_OK)
            throw new RuntimeException("Authentication Failed. Content of failed Response: "
                    + response + " , Status Code : " + response.statusCode());
        response.body().prettyPrint();
        return new ResponseManager<>(Token.class, response);
    }
}
