package timeoutsession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * It's only 1 thread!
 */
@WebServlet("/timeoutservlet")
public class TimeoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = null;
        if(SessionLocator.flag) {
            // создание сессии и установка времени инвалидации
            session = request.getSession();
            // 10 seconds
            int timeLive = 10;
            session.setMaxInactiveInterval(timeLive);
            SessionLocator.flag = false;
        } else {
            // if session is not exists, then NULL
            session = request.getSession(false);
            if(session == null) {
                SessionLocator.flag = true;
            }
        }
        request.setAttribute("messages", SessionLocator.addMessages(session));
        request.getRequestDispatcher("/jsp/time.jsp").forward(request, response);
    }
}
