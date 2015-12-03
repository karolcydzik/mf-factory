package com.omn.mpfactory.utils;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ConfrimationStringHelperTest {
	
    private static Log LOG = LogFactory.getLog(ConfrimationStringHelperTest.class);
    private static String CONFIRMATION_STRING = "XXXXX004user005email008passwordYYYYYYYYYYYYYYYYYYY"
    		+ "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY"
    		+ "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY"
    		+ "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY"
    		+ "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY";
             //123456789 123456789 123456789 123456789 123456789 

	ConfirmationStringHelper helper = new ConfirmationStringHelper();
	
	@Test
	public void testCreateConfirmationString() {
		LOG.info(helper.getConfirmationString("user", "email", "password"));
		assertEquals(CONFIRMATION_STRING, helper.getConfirmationString("user", "email", "password"));
	}

	@Test
	public void testGetPassword() {
		assertEquals("password", helper.getPassword(CONFIRMATION_STRING));
	}

	@Test
	public void testGetUser() {
		assertEquals("user", helper.getNick(CONFIRMATION_STRING));
	}

	@Test
	public void testGetEmail() {
		assertEquals("email", helper.getEmail(CONFIRMATION_STRING));
	}

}
