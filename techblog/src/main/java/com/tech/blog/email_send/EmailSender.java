package com.tech.blog.email_send;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    private Properties properties;

    public EmailSender() {
        properties = new Properties();
        properties.setProperty("mail.smtp.host", "localhost");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "1025");
        properties.setProperty("mail.smtp.starttls.enable", "true");
    }

    public void sendEmail(String to, String title, String body) throws MessagingException {
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("hello", "hello");
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("adrian@ciu.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(title);
        message.setText(body);

        Transport.send(message);
    }
}
