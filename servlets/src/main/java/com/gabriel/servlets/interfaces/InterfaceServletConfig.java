package com.gabriel.servlets.interfaces;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * web.xml
 *  <servlet>
 *      <servlet-name>InterfaceServletConfig</servlet-name>
 *      <servlet-class>InterfaceServletConfig</servlet-class>
 *          <init-param>
 *              <param-name>first</param-name>
 *              <param-value>first@</param-value>
 *          </init-param>
 *          <init-param>
 *              <param-name>second</param-name>
 *          <param-value>second@</param-value>
 *          </init-param>
 *  </servlet>
 *  <servlet-mapping>
 *      <servlet-name>InterfaceServletConfig</servlet-name>
 *      <url-pattern>/interfaceServletConfig</url-pattern>
 *  </servlet-mapping>
 */
@WebServlet(
        urlPatterns = {"/interfaceServletConfig"},
        initParams = {
                @WebInitParam(name="first", value="first@"),
                @WebInitParam(name="second", value="second@")
        })
public class InterfaceServletConfig extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        ServletConfig servletConfig = this.getServletConfig();

        writer.println("<h1>all init parameters:</h1>");
        writer.println("<br/>");
        Enumeration<String> names = servletConfig.getInitParameterNames();
        if(names != null) {
            while (names.hasMoreElements()) {
                String element = names.nextElement();
                writer.println(element + " - " + servletConfig.getInitParameter(element));
                writer.println("<br/>");
            }
        }

        writer.println("<h2>");
        writer.println("getServletName(): " + servletConfig.getServletName());
        writer.println("</h2>");


        writer.flush();
    }
}
