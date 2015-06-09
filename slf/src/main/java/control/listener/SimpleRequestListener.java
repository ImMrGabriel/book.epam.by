package control.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Обработка событий создания и уничтожения запроса к сервлету
 */
@WebListener
public class SimpleRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
        String uri = "Request Initialized for " + request.getRequestURI();
        String id = "Request Initialized with for " + request.getRequestedSessionId();
        System.out.println(uri + "\n" + id);
        ServletContext context = event.getServletContext();
        Integer requestCount = (Integer) request.getSession().getAttribute("counter");
        if(requestCount == null) {
            requestCount = 0;
        }
        context.log(uri + "\n" + id + ", Request Counter = " + requestCount);
    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        System.out.println("Request Destroyed: " +
            event.getServletRequest().getAttribute("lifecycle"));
    }
}
