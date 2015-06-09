package timeoutsession;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SessionLocator {
    private final static String BR = "<br/><hr/>";
    public static boolean flag = true;

    public static List<String> addMessages(HttpSession session) {
        List<String> messages = new ArrayList<>();
        if(session != null) {
            messages.add("Creation Time: " + new Date(session.getCreationTime()) + BR);
            messages.add("Session id: " + session.getId() + BR);
            messages.add("Session alive!" + BR);
        } else {
            messages.add("Session disable!" + BR);
        }
        return messages;
    }
}
