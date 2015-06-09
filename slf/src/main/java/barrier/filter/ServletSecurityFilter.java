package barrier.filter;

import barrier.client.ClientType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ‘ильтр, перенаправл€ющий все новых пользователей на гостевую страницу
 */
@WebFilter(
        urlPatterns = {"/controller"},
        servletNames = {"MainServlet"})
public class ServletSecurityFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        ClientType type = (ClientType) session.getAttribute("userType");
        if(type == null) {
            type = ClientType.GUEST;
            session.setAttribute("userType", type);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/jsp/guest.jsp");
            dispatcher.forward(request, response);
        }
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
