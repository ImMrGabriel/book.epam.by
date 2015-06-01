package logic;

/**
 * It's only for demo!
 */
public class LoginLogic {
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "qwe123";

    public static boolean checkLogin(String login, String pass) {
        return ADMIN_LOGIN.equals(login) && ADMIN_PASS.equals(pass);
    }
}
