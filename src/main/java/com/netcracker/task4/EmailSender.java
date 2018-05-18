package com.netcracker.task4;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

// http://localhost:8080/index.html

@WebServlet("/task4")
public class EmailSender extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String subject = req.getParameter("subject");
        String cc = req.getParameter("cc");
        String text = req.getParameter("text");


        final Properties properties = new Properties();
        properties.load(EmailSender.class.getClassLoader().getResourceAsStream("mail.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setFrom(new InternetAddress("DeadAngel666Rosko"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject(subject);
            message.setText(text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        try {
            Transport transport = mailSession.getTransport();
            transport.connect(null, "czhc9g9f");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        resp.getWriter().write("<a href=\"index.html\">back</a>");

    }

}

