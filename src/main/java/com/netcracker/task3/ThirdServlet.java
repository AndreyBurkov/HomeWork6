package com.netcracker.task3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// http://localhost:8080/task3

@WebServlet("/task3")
public class ThirdServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String s = "<!DOCTYPE html>" +
                "<html>" +
                "<body>" +
                "<h3>" + "Browser:   " + req.getHeader("user-agent") + "</h3>" +
                "<h3>" + "Date:   " + new Date().toString() + "</h3>" +
                "<a href=\"index.html\"><= back</a>" +
                "</body>" +
                "</html>";
        writer.write(s);
    }
}
