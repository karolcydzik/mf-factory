package com.omn.mpfactory.jsf.administation;

public enum AdministrationPagesEnum {

	LOGIN("login.xhtml"), 
	REGISTER("register.xhtml"), 
	AFTER_REGISTRATION("afterRegistration.xhtml");

	private String template;

	private AdministrationPagesEnum(String t) {
		this.template = t;
	}

	public String getTemplate() {
		return template;
	}
	
}
