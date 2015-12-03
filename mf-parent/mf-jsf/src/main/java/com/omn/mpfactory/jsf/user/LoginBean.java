package com.omn.mpfactory.jsf.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * The Class LoginBean.
 */
@ManagedBean(name = "loginMgmtBean", eager = true)
@RequestScoped
public class LoginBean {

	private String userName = "USER xxxxx";
	private String password = null;

	/**
	 * Login.
	 * 
	 * @return the string
	 */
	public String login() {
		return "Secured?faces-redirect=true";
	}

	/**
	 * Cancel.
	 * 
	 * @return the string
	 */
	public String cancel() {
		// administrationController.nextStep("REGISTER");
		return "/pages/common/administration.xhtml";
	}

	public String logout() {
		return "loggedout";
	}

	/**
	 * Gets the user name.
	 * 
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 * 
	 * @param userName
	 *            the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}