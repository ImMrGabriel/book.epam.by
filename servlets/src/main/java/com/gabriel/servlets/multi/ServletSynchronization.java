package com.gabriel.servlets.multi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/servletSynchronization")
public class ServletSynchronization extends HttpServlet {
    // synchronized object
    private final StringBuilder locked = new StringBuilder();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer out = resp.getWriter();
        out.write(makeString());
        out.flush();
    }

    private String makeString() {
        // original
        final String SYNCHRO = "SYNCHRONIZATION";
        synchronized (locked) {
            try {
                for (int i = 0; i < SYNCHRO.length(); i++) {
                    locked.append(SYNCHRO.charAt(i));
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                /*NOP*/
            }
            String result = locked.toString();
            locked.delete(0, SYNCHRO.length());
            return result;
        }
    }
}
