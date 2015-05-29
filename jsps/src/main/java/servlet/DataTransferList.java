package servlet;

import bean.MessageList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/el_list.do")
public class DataTransferList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doTransfer(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doTransfer(request, response);
    }

    private void doTransfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageList list = new MessageList();
        request.setAttribute("lst", list);
        request.getRequestDispatcher("el_list.jsp").forward(request, response);
    }
}
