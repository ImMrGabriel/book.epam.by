package com.gabriel.servlets.task1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task1/task1")
public class Task1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String parametr = request.getParameter("header");
        out.println("<p><a href=\"../index.jsp\">Return to main page</a></p>");
        out.println("<h1>" + (parametr == null ? "" : parametr) + "</h1>");
        int rows = 0;
        int cols = 0;
        parametr = request.getParameter("rows");
        if(parametr != null && parametr.matches("^[\\d]+$")) {
            rows = Integer.parseInt(parametr);
        }
        parametr = request.getParameter("cols");
        if(parametr != null && parametr.matches("^[\\d]+$")) {
            cols = Integer.parseInt(parametr);
        }
        String color = "123456";
        parametr = request.getParameter("color");
        if(parametr != null && parametr.matches("[\\da-fA-F]{6}")) {
            color = parametr;
        }
        out.println("<table bgcolor=\"" + color + "\">");
        for (int i = 0; i < rows; i++) {
            out.println("<tr>");
            for (int j = 0; j < cols; j++) {
                out.println("<td>*</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<p><a href=\"index.jsp\">Again</a></p>");
        out.flush();
    }
}
