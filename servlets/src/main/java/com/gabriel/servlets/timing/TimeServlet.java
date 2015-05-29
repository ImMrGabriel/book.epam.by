package com.gabriel.servlets.timing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

@WebServlet("/timing/timeaction")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GregorianCalendar gc = new GregorianCalendar();
        String timeJsp = request.getParameter("time");
        float delta = ((float)(gc.getTimeInMillis() - Long.parseLong(timeJsp))) / 1_000;
        request.setAttribute("res", delta);
        // forward - relative path and old request;
        // sendRedirect - absolute path and new request
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }


}
