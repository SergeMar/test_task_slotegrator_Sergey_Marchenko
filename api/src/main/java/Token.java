public class Token {

    private static String token;

    private Token() {
    }

    public static String getInstance() {
        if (token == null) {
            token = new ApiController().login().getAccessToken();;
        }
        return token;
    }
}
