package sources;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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


        public void create_mail(String user, String site, String url, String send_to) throws Exception{

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
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(send_to));

//            This is for CC address
            /*String address = "sannila1527@gmail.com,sannila4369@gmail.com";
            InternetAddress[] iAdressArray = InternetAddress.parse(address);
            message.addRecipients(Message.RecipientType.CC, iAdressArray);*/

            // Add subject line
            message.setSubject("KMIT Automation Test Result");

//            message.setContent("Find the attachment for the results", "text/html");

//            Add the file attachment
            String fileName = "KMIT E-comm Test Result";

            Multipart multipart = new MimeMultipart();
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Hi,\nTest Completed to the given site: " + site + " - " + url + "\nKindly check for \"Selenium_images\" folder created in your desktop, for any error screenshots.\nFind the attachment for more details.\n");

            MimeBodyPart attachment = new MimeBodyPart();
            DataSource source = new FileDataSource(new File("src\\logfile.log").getAbsolutePath());
            attachment.setDataHandler(new DataHandler(source));
            attachment.setFileName("Test_Result.txt");

            multipart.addBodyPart(textBodyPart);
            multipart.addBodyPart(attachment);

            message.setContent(multipart);

//****
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", "sannila4369@gmail.com", "sannila@1");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e){
            e.printStackTrace();
        }

    }
}
