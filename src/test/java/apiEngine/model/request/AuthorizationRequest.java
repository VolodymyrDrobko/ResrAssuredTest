package apiEngine.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorizationRequest {
    private String userName;
    private String password;
}
