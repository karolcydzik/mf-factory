package com.omn.mpfactory.email;

/*====================================================================================
 |                                                                                    |        
 |  This is a standalone program for testing connection with Gmail IMAP server        |
 |  and displays the No. of unread messages and the list of folders                   |
 |                                                                                    |
 |  How to run:                                                                       |
 |                                                                                    |
 |    java GmailIMAPTest GmailUsername GMailPassword                                  |
 |                                                                                    |
 |                                                                                    |
 =====================================================================================*/
import java.util.Properties;
/*
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
*/
public class GmailIMAPTest {
/*
    public static void main(String[] args) throws MessagingException {

        Folder mInbox;
        Store mStore;
        Session mSession;
        Authenticator authenticator = null;
        Properties imapProperties = new Properties();
        String gmailUsername = null;
        String gmailPwd = null;

//        if (args.length > 1) {
//            gmailUsername = args[0];
//            gmailPwd = args[1];
//        } else {
//            System.out.println("Pass all the required parameters. eg: java GmailIMAPTest" + " GmailUsername AccountPassword");
//            System.exit(0);
//        }

         gmailUsername = "chboar@gmail.com";
         gmailPwd = "Szafir123";
        
         setEnvProp();
         
        imapProperties.put("mail.store.protocol", "imap");
        imapProperties.put("java.home","c:/Program Files/Java/jdk1.8.0_20");
//      imapProperties.put("mail.imap.host", "imap.gmail.com");
        imapProperties.put("mail.imap.host", "smtp.gmail.com");
        imapProperties.put("mail.imap.user", gmailUsername);
//        imapProperties.put("mail.imap.port", String.valueOf(993));
        imapProperties.put("mail.imap.port", String.valueOf(587));
        imapProperties.put("mail.imap.timeout", "200000");
        imapProperties.put("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        imapProperties.put("mail.imap.socketFactory.fallback", "false");
        imapProperties.put("mail.imap.socketFactory.port", Integer.toString(993));
        authenticator = new PwdAuthenticator(gmailUsername, gmailPwd);

        try {

            mSession = Session.getInstance(imapProperties, authenticator);
            mStore = mSession.getStore();
            mStore.connect("smtp.gmail.com", 587, gmailUsername, gmailPwd);

            System.out.println("Connected to IMAP Store");

            mInbox = mStore.getFolder("Inbox");
            int count = mInbox.getUnreadMessageCount();

            System.out.println("No of unread messages in IMAP inbox are " + count);

            Folder defaultFolder = mStore.getDefaultFolder();
            Folder[] serverFolders = defaultFolder.listSubscribed("*");

            System.out.println("Folders defined are:");

            if (serverFolders != null) {
                for (int x = 0; x < serverFolders.length; x++) {
                    System.out.println(serverFolders[x].getFullName() + "\n");
                }
            } else
                System.out.println("No folders found!");

        } catch (Exception e) {
            System.out.println("Exception occurred when establishing connection with Gmail IMAP server ->" + e.toString());
            e.printStackTrace();
        }

    }
    
    private static void setEnvProp(){
        Properties prop = new Properties();
        prop.put("javax.net.ssl.trustStore","c:/Users/Karol/.keytool/cacerts");
        prop.put("javax.net.ssl.trustStorePassword","changeit");
        System.setProperties(prop);
    }

}

class PwdAuthenticator extends Authenticator {
    String username;
    String password;

    PwdAuthenticator(String name, String passd) {
        username = name;
        password = passd;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
*/
}