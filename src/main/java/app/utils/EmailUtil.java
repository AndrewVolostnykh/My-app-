package app.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.Authenticator;

class EmailUtil {

    /**Method that sending message for user with link for confirm his email*/
    static synchronized void sendMessage(String email, String activationCode)
    {
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccount = "zighalt790@gmail.com";
        String myPass = "andrew1679438520";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, myPass);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("My app:) Confirm your registration. ");
            message.setText("Hi, to confirm your registration follow the link: \n" +
                    "http://77.47.204.220:8189/webattempt_war_exploded/verification?email=" + email + "&code=" + activationCode + "\n"
                     + "If you didnt register please do nothing. " +
                    "\nGood luck!");
            Transport.send(message);

            System.out.println("crutch: message transported");
            System.out.println( "http://77.47.204.220:8189/webattempt_war_exploded/verification?email=" + email + "&code=" + activationCode );
            System.out.println("LOG(Sending message): Message to " + email + " tried to send. ");

        } catch (Exception e)
        {
            System.err.println("LOG(Sending email): WARNING!!! " + e);
        }
    }
}
