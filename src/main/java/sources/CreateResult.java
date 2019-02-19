package sources;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CreateResult {


        public static MimeMessage message;
        public static Session session;


        public void create_mail(String user, String site, String url) throws Exception{

        /* https://support.google.com/a/answer/7223765?hl=en
        *
        * to use KMIT Email in from address
         */

            // Create object of Property file
            Properties prop = new Properties();

            prop.put("mail.smtp.starttls.enable", "true");

            // this will set host of server- you can change based on your requirement
            prop.put("mail.smtp.host", "smtp.gmail.com");

            prop.put("mail.smtp.user", "sannila4369@gmail.com");
            prop.put("mail.smtp.password", "sannila@1");

            // set the port of SMTP server
            prop.put("mail.smtp.port", "587");

            // set the authentication to true
            prop.put("mail.smtp.auth", "true");

            session = Session.getDefaultInstance(prop, null);

            try {

            // Create object of MimeMessage class
            message = new MimeMessage(session);

            // set the form address
            message.setFrom(new InternetAddress("sannila4369@gmail.com"));

            // Set the recipient address
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("sanjaim@kmitsolutions.com"));

            String address = "sannila1527@gmail.com,sannila4369@gmail.com";
            InternetAddress[] iAdressArray = InternetAddress.parse(address);
            message.addRecipients(Message.RecipientType.CC, iAdressArray);

            // Add subject line
            message.setSubject("KMIT Automation Test Result");

            /*message.setContent("This is sample Message Content", "text/html");
            message.setContent("Hi " + user + "\n Test Completed for " + site + " with following url: " + url, "text/html");*/




        } catch (MessagingException e){
            e.printStackTrace();
        }

    }

    public void close_email(String messages)throws Exception{
        try {
                message.setContent(messages, "text/html");
                Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", "sannila4369@gmail.com", "sannila@1");
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();

                System.out.println("message sent");
        } catch (MessagingException e){
                e.printStackTrace();
        }
    }
}
