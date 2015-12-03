package com.omn.mpfactory.jsf.manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "jsfModel", eager = true)
@SessionScoped

public class JsfModel {
    
    private NavigationEnum adminArea;

    public NavigationEnum getAdminArea(String defArea) {
        if(adminArea == null){
            adminArea = NavigationEnum.REGISTER;
        }
        return adminArea;
    }

    public void setAdminArea(NavigationEnum adminArea) {
        this.adminArea = adminArea;
    }

    public NavigationEnum getAdminArea() {
        return adminArea;
    }
    
}