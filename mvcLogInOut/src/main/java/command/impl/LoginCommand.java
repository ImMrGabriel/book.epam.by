package command.impl;

import command.ActionCommand;
import logic.LoginLogic;
import resource.ConfigurationManager;
import resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        // extract the login and the password from the request
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        // check the login and the password
        if(LoginLogic.checkLogin(login, pass)) {
            // Successful
            request.setAttribute("user", login);
            // define the path to main.jsp
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            // define the path to login.jsp
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
