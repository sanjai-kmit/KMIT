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




    public void create_mail(String user, String site, String url) throws Exception{


            // Create object of Property file
            Properties prop = new Properties();

            prop.put("mail.smtp.starttls.enable", "true");

            // this will set host of server- you can change based on your requirement
            prop.put("mail.smtp.host", "smtp.gmail.com");

            prop.put("mail.smtp.user", "sannila4369@gmail.com");
            prop.put("mail.smtp.password", "sannila@1");

            // set the port of socket factory
//            prop.put("mail.smtp.socketFactory.port", "456");

            // set socket factory
//            prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            // set the port of SMTP server
            prop.put("mail.smtp.port", "587");

            // set the authentication to true
            prop.put("mail.smtp.auth", "true");


            // This will handle the complete authentication
/*            Session session = Session.getDefaultInstance(prop,
                    new javax.mail.Authenticator(){
                        protected PasswordAuthentication getPasswordAuthentication(){
                            return new PasswordAuthentication("sannila4369@gmail.com", "sannila@1");
                        }
                    }
            );*/

            Session session = Session.getDefaultInstance(prop, null);

            try {

            // Create object of MimeMessage class
            MimeMessage message = new MimeMessage(session);

            // set the form address
            message.setFrom(new InternetAddress("sannila4369@gmail.com"));

            // Set the recipient address
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("sannila4369@gmail.com"));

            // Add subject line
            message.setSubject("KMIT Automation Test Result");

            message.setContent("This is sample Message Content", "text/html");
            message.setContent("Hi " + user + "\n Test Completed for " + site + " with following url: " + url, "text/html");


            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", "sannila4369@gmail.com", "sannila@1");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("message sent");

        } catch (MessagingException e){
            e.printStackTrace();
        }

    }


    /*
    public Writer wr;

    public void create_html(String date)throws Exception{

        String username = System.getProperty("user.name");
        File directory_path = new File("C:\\Users\\" + username + "\\Desktop\\Automation_Test_Result");
        if (!directory_path.exists()){
            new File("C:\\Users\\" + username + "\\Desktop\\Automation_Test_Result").mkdirs();
        }

        try {
            wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(directory_path + "\\" + date + ".html")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void close_html() throws Exception{
        wr.close();
    }*/
}
