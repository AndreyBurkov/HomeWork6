package com.netcracker.task1and2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


// http://localhost:8080/login.html

public class FirstServlet extends HttpServlet {

    private static String PASSWORD = "1234";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        if (password.equals(PASSWORD)) {
            String s = "<!DOCTYPE html>" +
                    "<html>" +
                    "<body>" +
                    "<h3>" + "Password: OK " + "</h3>" +
                    "<h3>" + "Hello, " + login + "</h3>" +
                    "<a href=\"index.html\"><= back</a>" +
                    "</body>" +
                    "</html>";
            writer.write(s);
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Password is not correct!!!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}