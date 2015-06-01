package servlet;

import command.ActionCommand;
import command.factory.ActionFactory;
import resource.ConfigurationManager;
import resource.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        // definition a command from the request
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        /* call the implementing method execute() and passing parameters
        to the specified command class */
        page = command.execute(request);
        // the method returns the response page
        // todo: page == null ?!?
        if(page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            // call the request page to the request
            dispatcher.forward(request, response);
        } else {
            // set the page with the error message
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
