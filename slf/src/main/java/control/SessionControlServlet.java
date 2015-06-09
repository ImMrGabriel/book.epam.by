package control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionServlet")
public class SessionControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* true - if there's no current session then it creates new session
        (false - return null) */
        HttpSession session = request.getSession(true);
        if(session.getAttribute("role") == null) {
            session.setAttribute("role", "moderator");
        }
        /* количество запросов, которые были сделаны
          к данному сервлету текущим пользователем
          в рамках текущей пользовательской сессии */
        Integer counter = (Integer) session.getAttribute("counter");
        if(counter == null) {
            session.setAttribute("counter", 1);
        } else {
            session.setAttribute("counter", ++counter);
        }
        request.setAttribute("lifecycle", "CONTROL request LIFECYCLE");
        request.getRequestDispatcher("/jsp/sessionattr.jsp").forward(request, response);
    }
}
