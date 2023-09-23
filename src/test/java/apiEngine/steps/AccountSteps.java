package apiEngine.steps;

import apiEngine.endpoints.AccountEndPoints;
import apiEngine.model.request.AuthorizationRequest;
import apiEngine.model.response.IResponse;
import apiEngine.model.response.RegisteredUser;
import apiEngine.model.response.Token;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class AccountSteps {
    private final AccountEndPoints endpoints = new AccountEndPoints();
    private IResponse<RegisteredUser> registeredUserIResponse;
    private IResponse<Token> tokenIResponse;

    public void registerUser(String userName, String password) {
        AuthorizationRequest authorizationRequest = new AuthorizationRequest(userName, password);
        registeredUserIResponse = endpoints.registerUser(authorizationRequest);
        Assert.assertEquals(registeredUserIResponse.getStatusCode(), HttpStatus.SC_CREATED);
    }

    public String getUserId() {
        return registeredUserIResponse.getBody().userID;
    }

    public void generateToken(String userName, String password) {
        AuthorizationRequest authorizationRequest = new AuthorizationRequest(userName, password);
        tokenIResponse = endpoints.generateToken(authorizationRequest);
        Assert.assertEquals(tokenIResponse.getStatusCode(), HttpStatus.SC_OK);
    }

    public Token getToken() {
        return tokenIResponse.getBody();
    }
}
