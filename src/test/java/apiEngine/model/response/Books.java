package apiEngine.model.response;

import apiEngine.model.Book;
import lombok.Data;

import java.util.List;

@Data
public class Books {
    public List<Book> books;
}
