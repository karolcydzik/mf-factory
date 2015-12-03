package com.omn.mpfactory.email;

import java.util.Properties;

public class EmailUtil {

    public Properties getMailProperties() {
        Properties properties = new Properties();
//        properties.setProperty("mail.transport.protocol", "smtp");
//        properties.setProperty("mail.debug", "false");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        return properties;
    }
}
