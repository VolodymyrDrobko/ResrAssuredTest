package apiEngine.route;

public class Route {
    public static final String ACCOUNT = "/Account";
    public static final String V_1 = "/v1";
    public static final String BOOK_STORE = "/BookStore";

    public static String registerUser() {
        return ACCOUNT + V_1 + "/User";
    }

    public static String generateToken() {
        return ACCOUNT + V_1 + "/GenerateToken";
    }

    public static String getBooks() {
        return BOOK_STORE + V_1 + "/Books";
    }

    public static String getBook() {
        return BOOK_STORE + V_1 + "/Book";
    }

    public static String getAccountUser(String USER_ID) {
        return ACCOUNT + V_1 + "/User/" + USER_ID;
    }
}
