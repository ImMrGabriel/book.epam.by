package com.gabriel.servlets.first;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *  <servlet>
 *      <servlet-name>FirstServletName</servlet-name>
 *      <servlet-class>com.gabriel.servlets.first.FirstServlet</servlet-class>
 *  </servlet>
 *  <servlet-mapping>
 *      <servlet-name>FirstServletName</servlet-name>
 *      <url-pattern>/FirstServletTest</url-pattern>
 *  </servlet-mapping>
 */
@WebServlet(name = "FirstServletName", urlPatterns = {"/FirstServletTest"})
//@WebServlet("/FirstServletTest")
public class FirstServlet extends HttpServlet {
    public FirstServlet() {
    }

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("This is " + this.getClass().getName() + ", using the GET method");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("This is " + this.getClass().getName() + ", using the POST method");

    }

    @Override
    public void destroy() {
        super.destroy();        // Just puts "destroy" string in log
    }
}
