package com.gabriel.servlets.interfaces;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;

@WebServlet("/interfaceHttpServletRequest")
public class InterfaceHttpServletRequest extends HttpServlet {

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

        Enumeration<String> parameterNames = request.getParameterNames();
        writer.println("<h1>all request parameters:</h1><br/>");

        if(parameterNames != null) {
            while (parameterNames.hasMoreElements()) {
                String element = parameterNames.nextElement();
                String[] parameters = request.getParameterValues(element);
                if(parameters != null && parameters.length > 0) {
                    writer.println(element + " - " + Arrays.toString(parameters));
                    writer.println("<br/>");
                }
                writer.println(element + " - " + request.getParameter(element));
                writer.println("<br/>");
            }
        }
        writer.println("<h5>");
        writer.println("getCharacterEncoding(): " + request.getCharacterEncoding());
        writer.println("<br/>getContentType(): " + request.getContentType());
        writer.println("<br/>getProtocol(): " + request.getProtocol());
        writer.println("<br/>getServerName(): " + request.getServerName());
        writer.println("<br/>getServerPort(): " + request.getServerPort());
        writer.println("<br/>getRemoteAddr(): " + request.getRemoteAddr());
        writer.println("<br/>getRemoteHost(): " + request.getRemoteHost());
        writer.println("<br/>getRemoteUser(): " + request.getRemoteUser());
        writer.println("<br/>getQueryString(): " + request.getQueryString());
        writer.println("<br/>getMethod(): " + request.getMethod());
        writer.println("<br/>getScheme(): " + request.getScheme());
        writer.println("</h5>");

        Enumeration<String> attributeNames = request.getAttributeNames();
        writer.println("<h2>all request attributes:</h2><br/>");
        while (attributeNames.hasMoreElements()) {
            String element = attributeNames.nextElement();
            writer.println(element + " - " + request.getAttribute(element) + "<br/>");
        }

        writer.println("<h3>add request attributes!</h3><br/>");
        request.setAttribute("date", new Date());
        attributeNames = request.getAttributeNames();
        writer.println("<h2>all request attributes:</h2><br/>");
        while (attributeNames.hasMoreElements()) {
            String element = attributeNames.nextElement();
            writer.println(element + " - " + request.getAttribute(element) + "<br/>");
        }

        writer.println("<h2>all request cookies:</h2><br/>");
        Cookie[] cookies = request.getCookies();
        if(cookies == null || cookies.length == 0) {
            writer.println("<p>Cookies are empty</p>");
        } else {
            for(Cookie cookie : cookies) {
                writer.println(cookie.getName() + " - " + cookie.getValue() + " - " + cookie.getPath() + " - " +
                        cookie.getDomain() + " - " + cookie.getComment() + " - " + cookie.getMaxAge() + "<br/>");
            }
        }

        writer.println("<h3>add cookie!</h3><br/>");
        response.addCookie(new Cookie("greeting", "hello!"));
        writer.println("<h2>all request cookies:</h2><br/>");
        cookies = request.getCookies();
        if(cookies == null || cookies.length == 0) {
            writer.println("<p>Cookies are empty</p>");
        } else {
            for(Cookie cookie : cookies) {
                writer.println(cookie.getName() + " - " + cookie.getValue() + " - " + cookie.getPath() + " - " +
                        cookie.getDomain() + " - " + cookie.getComment() + " - " + cookie.getMaxAge() + "<br/>");
            }
        }

        writer.println("<h2>all request headers:</h2><br/>");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String element = headerNames.nextElement();
            writer.println(element + " - " + request.getHeader(element) + "<br/>");
        }



        writer.flush();
    }
}
