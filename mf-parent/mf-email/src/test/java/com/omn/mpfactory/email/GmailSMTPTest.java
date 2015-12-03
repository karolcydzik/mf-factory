package com.omn.mpfactory.email;

/*====================================================================================
 |                                                                                    |        
 |  This is a standalone program for testing connection with Gmail SMTP server        |
 |  and sends a test mail to the given email address                                  |
 |                                                                                    |
 |  How to run:                                                                       |
 |                                                                                    |
 |    java GmailSMTPTest GmailUsername gMailPassword recipientEmailAddress            |
 |                                                                                    |
 |                                                                                    |
 =====================================================================================*/

import java.util.Date;
import java.util.Properties;
/*
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
*/
public class GmailSMTPTest {
    /*     

    public static void main(String args[]) {
        String gmailUsername = null;
        String gmailPwd = null;
        String recpEmailAddr = null;
        Properties smtpProperties = new Properties();

//        if (args.length > 2) {
//            gmailUsername = args[0];
//            gmailPwd = args[1];
//            recpEmailAddr = args[2];
//        } else {
//            System.out.println("Pass all the required parameters. eg: java GmailSMTPTest" + " GmailUsername AccountPassword");
//            System.exit(0);
//        }
        

   gmailUsername = "chboar@gmail.com";
   gmailPwd = "Szafir123";
   recpEmailAddr = "chboar@gmail.com";

        setEnvProp();

        smtpProperties.put("mail.store.protocol", "smtp");
        smtpProperties.put("mail.smtp.host", "smtp.gmail.com");
        smtpProperties.put("mail.smtp.auth", "true"); // It is mandatory till
                                                      // JavaMail 1.4.1
        smtpProperties.put("mail.smtp.user", gmailUsername);

        smtpProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        smtpProperties.put("mail.smtp.socketFactory.fallback", "false");
        smtpProperties.put("mail.smtp.socketFactory.port", Integer.toString(465));

        GmailSMTPTest msg2 = new GmailSMTPTest();

        Authenticator authenticator = msg2.getAuthenticator(gmailUsername, gmailPwd);
        Session session = Session.getInstance(smtpProperties, authenticator);

        Address[] addresses = null;
        MimeMessage mimeMessage = new MimeMessage(session);

        try {
            Address[] from = InternetAddress.parse("Workflow Mailer <wf_from@domain.com>", false);
            mimeMessage.addFrom(from);
            mimeMessage.setRecipients(Message.RecipientType.TO, recpEmailAddr);

            mimeMessage.setSubject("Test mail");
            mimeMessage.setText("This is just a test mail \n");
            mimeMessage.setSentDate(new Date());
            addresses = InternetAddress.parse(recpEmailAddr, false);
            mimeMessage.setFrom(from[0]);
            Transport.send(mimeMessage, addresses);

            System.out.println("Test message sent to the email address->" + recpEmailAddr);
        } catch (Exception ex) {
            System.out.println("Exception occurred when establishing connection with Gmail SMTP server ->" + ex.toString());
            ex.printStackTrace();
        }

    }

    Authenticator getAuthenticator(String userName, String pwd) {
        return new TestAuthenticator(userName, pwd);
    }
    
    private static void setEnvProp(){
        Properties prop = new Properties();
        prop.put("javax.net.ssl.trustStore","c:/Users/Karol/.keytool/cacerts");
        prop.put("javax.net.ssl.trustStorePassword","changeit");
        prop.put("file.encoding", "UTF-8");
        System.setProperties(prop);
    }

}

class TestAuthenticator extends Authenticator {
    String username;
    String password;

    TestAuthenticator(String name, String passd) {
        username = name;
        password = passd;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
**/
}
