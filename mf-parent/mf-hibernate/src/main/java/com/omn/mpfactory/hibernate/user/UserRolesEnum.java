package com.omn.mpfactory.hibernate.user;

public enum UserRolesEnum {
    
    ADMIN("admin"), USER("user");
    
    UserRolesEnum(String value){
        this.value = value;
    }
    
    private String value;
    
    public String getValue(){
        return value;
    }

}
