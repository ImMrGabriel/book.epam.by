package servlet;

import bean.MessageMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/el_map.do")
public class DataTransferMap extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doTransfer(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doTransfer(request, response);
    }

    private void doTransfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageMap map = new MessageMap();
        request.setAttribute("map", map);
        request.getRequestDispatcher("el_map.jsp").forward(request, response);
    }
}
