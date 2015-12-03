package com.tutorialspoint.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "helloWorldXX", eager = true)
public class HelloWorldXX {

   @ManagedProperty(value="#{message}")
   private Message messageBean;

   private String message;

   public HelloWorldXX() {
      System.out.println("HelloWorld started!");   
   }
   public String getMessage() {
      if(messageBean != null){
         message = messageBean.getMessage();
      }       
      return message;
   }
   public void setMessageBean(Message message) {
      this.messageBean = message;
   }
}