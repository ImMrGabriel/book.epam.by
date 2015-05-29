package com.gabriel.servlets.interfaces;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

@WebServlet("/interfaceServletContext")
public class InterfaceServletContext extends HttpServlet {

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

        ServletContext servletContext = this.getServletContext();

        String admin = servletContext.getInitParameter("administrator");
        writer.println("<h5>administrator: " + admin + "</h5>");
        writer.println("<br/>");

        writer.println("<h1>all init parameters:</h1>");
        writer.println("<br/>");
        Enumeration<String> names = servletContext.getInitParameterNames();
        if(names != null) {
            while (names.hasMoreElements()) {
                String element = names.nextElement();
                writer.println(element + " - " + servletContext.getInitParameter(element));
                writer.println("<br/>");
            }
        }

        writer.println("<h1>all attributes:</h1>");
        writer.println("<br/>");
        names = servletContext.getAttributeNames();
        if(names != null) {
            while (names.hasMoreElements()) {
                String element = names.nextElement();
                writer.println(element + " - " + servletContext.getAttribute(element));
                writer.println("<br/>");
            }
        }

        writer.println("<h1>Add attribute:</h1>");
        writer.println("<br/>");
        Date date = new Date();
        servletContext.setAttribute("date", date);

        names = servletContext.getAttributeNames();
        if(names != null) {
            while (names.hasMoreElements()) {
                String element = names.nextElement();
                writer.println(element + " - " + servletContext.getAttribute(element));
                writer.println("<br/>");
            }
        }

        servletContext.removeAttribute("date");

        writer.println("<h2>");
        writer.println("getRealPath(\"timing.jsp\"): " + servletContext.getRealPath("timing/timing.jsp"));
        writer.println("<br/>");
        writer.println("getRealPath(\"index.jsp\"): " + servletContext.getRealPath("index.jsp"));
        writer.println("<br/>");
        writer.println("getServerInfo(): " + servletContext.getServerInfo());
        writer.println("<br/>");
        writer.println("getContextPath(): " + servletContext.getContextPath());
        writer.println("<br/>");
        writer.println("getServletContextName(): " + servletContext.getServletContextName());
        writer.println("</h2>");

        servletContext.log(date.toString() + ". I was here!");

        writer.flush();
    }
}
