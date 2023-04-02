package com.tech.blog.email_send;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    /***
     * This class is used to email a user
     */

    private Properties properties;

    public EmailSender() {
        properties = new Properties();
        properties.setProperty("mail.smtp.host", "localhost");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "1025");
        properties.setProperty("mail.smtp.starttls.enable", "true");
    }

    /**
     * This class is used to email a person
     * @param to is the email address of the person where the email will be sent
     * @param title is the title of the email
     * @param body is the content of the email
     * @throws MessagingException
     */
    public void sendEmail(String to, String title, String body) throws MessagingException {
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("hello", "hello");
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("staff.techblog@techblog.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(title);
        message.setText(body);

        Transport.send(message);
    }
}
