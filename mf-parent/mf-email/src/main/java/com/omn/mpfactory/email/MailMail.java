package com.omn.mpfactory.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailMail {

    @Autowired
    private MailSender mailSender;

    public void sendMail(String from, String to, String subject, String msg) {

//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(msg);
//        mailSender.javaMailService().send(message);
    }
}
