package com.omn.mpfactory.jsf.user;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.omn.mpfactory.jsf.restfull.client.user.UserService;
import com.omn.mpfactory.jsf.util.BeanUtil;
import com.omn.mpfactory.jsf.util.Constants;
import com.omn.mpfactory.jsf.util.Util;
import com.omn.mpfactory.transport.user.UserType;

@ManagedBean(name = "userBean", eager = true)
@RequestScoped
public class UserBean {

    private static Log LOG = LogFactory.getLog(UserBean.class);
    private long id;
    
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Bad email format.")
    private String email;

    @Size(min = 5, max = 20, message = "Password length must be between {min} and {max} characters.")
    private String password;
    private String passwordConfirm;
    private String confirmationString="XXXXXXX-rubbish";

    @Size(min = 5, max = 100, message = "Nick length must be between {min} and {max} characters.")
    private String nick;
    private Long companyId;
    
    @ManagedProperty(value = "userService")
    UserService userService;
    
    @ManagedProperty(value = "beanUtil")
    BeanUtil beanUtil;

    public boolean isEmailUnique(){
        boolean isEmail = userService.isEmail(email, id);
        if(isEmail){
            Util.addFacesMessage(Constants.REGISTER_EMAIL_ID, Constants.REGISTER_EMAIL_HAS_TO_BE_UNIQUE);
        }
        return isEmail;
    }

    public String saveUser(){
        if(validateFailed()){
            return "administration";
        }
        LOG.debug(String.format("Save userId=[%s].", id));
        UserType user = getTranslatedUser();
        userService.createOrUpdate(user);
        confirmationString = user.getConfirmationString();
        return "/pages/common/administration/afterRegistration.xhtml";        
    }
    
    private boolean validateFailed(){
        boolean result=false;
        if(userService.isNick(nick, id)){
            Util.addFacesMessage(Constants.REGISTER_NICK_ID, Constants.REGISTER_NICK_HAS_TO_BE_UNIQUE);
            result=true;
        }
        if(userService.isEmail(email, id)){
            Util.addFacesMessage(Constants.REGISTER_EMAIL_ID, Constants.REGISTER_EMAIL_HAS_TO_BE_UNIQUE);
            result=true;
        }
        if(!password.equals(passwordConfirm)){
            Util.addFacesMessage(Constants.REGISTER_PASSWORDCONFIRM_ID, Constants.REGISTER_PASSWORD_PASSWORDCONFIRM_THE_SAME);
            result=true;
        }
        return result;
    }
    
    public String cancelEditUser(){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        Map<String,String> requestParams = ec.getRequestParameterMap();
        for(String key:requestParams.keySet()){
            LOG.info(String.format("Parameters string key=[%s], value=[%s]", key, requestParams.get(key)));            
        }
        LOG.info("Cancel edit user.");
        return null;
    }

    private UserType getTranslatedUser() {
        UserType user = new UserType();
        user.setEmail(email);
        user.setNick(nick);
        user.setPasswordHash(beanUtil.gethashedString(password));
        user.setCompanyId(companyId);
        return user;
    }
    
    public void reset(){
    	email = null;
    	nick = null;
    	password = null;
    }
    
    public int confirmUser(String confirmationString){
    	return userService.confirmUserByConfirmationString(confirmationString);
    }
    
    public boolean isLoggedIn(){
    	return false;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

	public String getConfirmationString() {
		return confirmationString;
	}
    
}
