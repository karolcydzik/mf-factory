package com.omn.mpfactory.jsf.administation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdministrationControllerTest {
	
	private AdministrationController ac = new AdministrationController();

	@Test
	public void testGetStep() {
		ac.nextStep("LOGIN");
		assertEquals("login.xhtml",ac.getStep());
		ac.nextStep("REGISTER");
		assertEquals("register.xhtml",ac.getStep());
		ac.nextStep("AFTER_REGISTRATION");
		assertEquals("afterRegistration.xhtml",ac.getStep());
		ac.nextStep("XXX");
		assertEquals("login.xhtml",ac.getStep());
		ac.nextStep(null);
		assertEquals("login.xhtml",ac.getStep());
	}
}
