package control.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Обработка событий добавления и изменения атрибута сессии
 *
 * web.xml
 * <listener>
 *      <listener-class>listener.SessionListenerImpl</listener-class>
 * </listener>
 */
@WebListener
public class SessionListenerImpl implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // log
        System.out.println("add: " + event.getClass().getSimpleName() +
            " : " + event.getName() + " : " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        // ignore
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("replace: " + event.getClass().getSimpleName() +
                " : " + event.getName() + " : " + event.getValue());
    }
}
