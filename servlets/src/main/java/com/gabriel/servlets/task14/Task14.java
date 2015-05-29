package com.gabriel.servlets.task14;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/task14/task14")
public class Task14 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String array = request.getParameter("array");
        if(array != null) {
            Set<Integer> set = new TreeSet<>();
            Pattern pattern = Pattern.compile("[\\d]+");
            Matcher matcher = pattern.matcher(array);
            while(matcher.find()) {
                set.add(Integer.parseInt(matcher.group()));
            }
            request.setAttribute("set", set);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }

    }
}
