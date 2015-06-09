package cookie.controller;

import cookie.action.CookieAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/cookiecontroller")
public class CookieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // add cookie
        CookieAction.setCookie(response);
        // extract cookie and add info in the request
        request.setAttribute("messages", CookieAction.addToRequest(request));
        request.getRequestDispatcher("/jsp/maincookie.jsp").forward(request, response);
    }
}
