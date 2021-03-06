package command.factory;

import command.ActionCommand;
import command.impl.EmptyCommand;
import command.client.CommandEnum;
import resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        // extract a command name from the request
        String action = request.getParameter("command");
        if(action == null || action.isEmpty()) {
            // if the command is not specified in the current request
            return current;
        }
        // get the object for the specified command
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
