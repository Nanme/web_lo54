package com.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Renaud on 19/06/2017.
 */
public class MailService {

    private Properties props = new Properties();
    private Session session;
    public MailService() {
        try {
            InputStream is = getClass().getResourceAsStream("/mail_prop.properties");

            props.load(is);

            MailAuthenticator auth = new MailAuthenticator();
            session = Session.getInstance(props, auth);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMail(String emailFrom, String emailTo) {
    try {
        // Create a default MimeMessage object.
        Message message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(emailFrom));

        // Set To: header field of the header.
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(emailTo));

        // Set Subject: header field
        message.setSubject("Testing Subject");

        // Now set the actual message
        message.setText("Hello, this is sample for to check send "
                + "email using JavaMailAPI ");

        // Send message
        Transport.send(message);

        System.out.println("Sent message successfully....");

    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
    }

    private class MailAuthenticator extends Authenticator {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(props.getProperty("username"),
                                              props.getProperty("password"));
        }
    }

}
