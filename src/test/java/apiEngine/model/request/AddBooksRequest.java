package apiEngine.model.request;

import apiEngine.model.ISBN;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddBooksRequest {
    public String userId;
    public List<ISBN> collectionOfIsbns;
}
