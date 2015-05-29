package com.gabriel.servlets.mail;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/mail/mailServlet")
public class MailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // запрос параметров почтового сервера из mail.properties
        Properties properties = new Properties();
        ServletContext context = getServletContext();
        String fileName = context.getInitParameter("mail");
        // загрузка параметров почтового сервера в объект свойств
        properties.load(context.getResourceAsStream(fileName));
        System.out.println(properties);
        System.out.println(request.getParameter("to"));
        System.out.println(request.getParameter("subject"));
        System.out.println(request.getParameter("body"));
        MailThread mailOperator = new MailThread(request.getParameter("to"), request.getParameter("subject"),
                request.getParameter("body"), properties);
        // запуск процесса отправки письма в отдельном потоке
        mailOperator.start();
        // переход на страницу с предложением о создании нового письма
        request.getRequestDispatcher("send.jsp").forward(request, response);

    }
}
