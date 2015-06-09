package cookie.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CookieAction {

    private static int number = 1;

    public static void setCookie(HttpServletResponse response) {
        String name = "JamesBond";
        String role = "00" + number++;
        Cookie cookie = new Cookie(name, role);
        // the lifetime the cookie in seconds
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        String value = response.getLocale().toString();
        Cookie locale = new Cookie("locale", value);
        response.addCookie(locale);
    }

    /**
     *
     * never returns NULL!
     * @param request
     * @return the list of cookie
     */
    public static List<String> addToRequest(HttpServletRequest request) {
        List<String> messages = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            messages.add("Number cookies : " + cookies.length);
            for(Cookie cookie : cookies) {
                messages.add(cookie.getName() + " = " + cookie.getValue());
            }
        }
        return messages;
    }
}
