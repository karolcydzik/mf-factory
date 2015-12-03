package com.omn.mpfactory.jsf.manager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@ManagedBean
@RequestScoped
public class Confirmation {
    
    private static Log LOG = LogFactory.getLog(Confirmation.class);

    @ManagedProperty(value = "#{param.key}")
    private String key;
    private boolean valid;

    @PostConstruct
    public void init() {
           //        valid = check(key); // And auto-login if valid?
        LOG.info("this is key=["+key+"]");
        valid=isValid();
    }

    public String click(){
        valid = isValid();
        return null;
    }
    
    private boolean isValid(){
        if(key != null && key.equals("aaaa")){
            return true;
        }        
        return false;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean getValid() {
        return this.valid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
