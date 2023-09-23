package apiEngine.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RemoveBookRequest {
    private String isbn;
    private String userId;
}
