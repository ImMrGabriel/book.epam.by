package command.impl;

import command.ActionCommand;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        // destroying session
        request.getSession().invalidate();
        return page;
    }
}
