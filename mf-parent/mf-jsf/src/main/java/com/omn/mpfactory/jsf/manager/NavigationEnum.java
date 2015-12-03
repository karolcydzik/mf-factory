package com.omn.mpfactory.jsf.manager;

public enum NavigationEnum {
    
    REGISTER("includes/register.xhtml"),
    CONFIRMATION("includes/confirmation.xhtml");
    
    private String template;

    private NavigationEnum(String t){
        template=t;
    }
    
    public String getTemplate() {
        return template;
    }

}