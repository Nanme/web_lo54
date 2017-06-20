package com.service;

import com.entity.Client;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Service use to send subscribe confirmation mail to a client.
 * Created by Renaud on 19/06/2017.
 */
public class MailService {

    private Properties props = new Properties();
    private Session session;

    /**
     * Create and initialize a {@link MailService}.
     */
    public MailService() {
        try {
            //Load property file.
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            props.load(cl.getResourceAsStream("mail_prop.properties"));

            //Create authenticator
            MailAuthenticator auth = new MailAuthenticator();

            //Create session instance
            session = Session.getInstance(props, auth);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Send the subscription confirmation mail to the {@param client} from mail set in mail_prop.properties.
     * @param client
     */
    public void sendingSubscriptionMail(Client client) {
        try {
            // Create a default MimeMessage object.
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(props.getProperty("emailfrom")));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(client.getEmail()));

            // Set Subject: header field
            message.setSubject("Subscription to " + client.getCourseSession().getCourse().getTitle());

            // Now set the actual message
            MimeBodyPart body = new MimeBodyPart();
            body.setContent(buildMail(client).toString(), "text/html");

            MimeMultipart part = new MimeMultipart();
            part.addBodyPart(body);
            message.setContent(part);

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private StringBuilder buildMail(Client client) {

        StringBuilder builder = new StringBuilder("<html><body>");
        builder.append("<h1>Subscription to " + client.getCourseSession().getCourse().getTitle() + "</h1>").append("<br />");
        builder.append("Hello " + client.getFirstName() + " " + client.getLastName() + ",").append("<br />");
        builder.append("We confirm that you have successfully subscribed to " + client.getCourseSession().getCourse().getTitle()
                        +  " from " + client.getCourseSession().getStartDate() + " to "
                        + client.getCourseSession().getEndDate() + " in "
                        + client.getCourseSession().getLocation().getCity()).append(".<br />");
        builder.append("Thanks to your attention").append(".<br />");
        builder.append("</body></html>");

        return builder;
    }

    /**
     * Create the authenticator uses to authenticate to the sender account set in mail_prop.properties.
     */
    private class MailAuthenticator extends Authenticator {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(/*props.getProperty("username")*/props.getProperty("username"),
                                              /*props.getProperty("password")*/props.getProperty("password"));
        }
    }

}
