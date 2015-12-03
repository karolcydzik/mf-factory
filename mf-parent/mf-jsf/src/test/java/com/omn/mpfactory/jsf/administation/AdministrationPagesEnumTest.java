package com.omn.mpfactory.jsf.administation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class AdministrationPagesEnumTest {

	@Test
	public void testGetTemplate() {
		assertEquals(AdministrationPagesEnum.LOGIN, AdministrationPagesEnum.valueOf("LOGIN"));
		assertEquals(AdministrationPagesEnum.REGISTER, AdministrationPagesEnum.valueOf("REGISTER"));
		assertEquals(AdministrationPagesEnum.AFTER_REGISTRATION, AdministrationPagesEnum.valueOf("AFTER_REGISTRATION"));
		assertNotEquals(AdministrationPagesEnum.AFTER_REGISTRATION, AdministrationPagesEnum.valueOf("LOGIN"));
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNotEnum() {
			AdministrationPagesEnum en = AdministrationPagesEnum.valueOf("LOGIN_XX");
	}

	@Test(expected=NullPointerException.class)
	public void testEnumIsNull() {
			AdministrationPagesEnum en = AdministrationPagesEnum.valueOf(null);
	}

}
