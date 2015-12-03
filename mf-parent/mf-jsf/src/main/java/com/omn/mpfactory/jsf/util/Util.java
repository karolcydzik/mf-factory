package com.omn.mpfactory.jsf.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class Util {
    
    public static void addFacesMessage(String componentId, String message) {
        UIComponent root = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent component = root.findComponent(componentId);
        FacesContext.getCurrentInstance().addMessage(component
            .getClientId(FacesContext.getCurrentInstance()),new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
    }

}
