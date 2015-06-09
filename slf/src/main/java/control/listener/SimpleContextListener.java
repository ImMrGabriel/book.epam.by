package control.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * ќбработка событий инициализации контекста
 */
@WebListener
public class SimpleContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        String mailFeedback = context.getInitParameter("feedback");
        context.log("Context Initialized with parameter: " + mailFeedback);
        System.out.println("Context Initialized with parameter: " + mailFeedback);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }
}
