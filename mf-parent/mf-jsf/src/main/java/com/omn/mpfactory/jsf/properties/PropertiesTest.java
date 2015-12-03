package com.omn.mpfactory.jsf.properties;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

public class PropertiesTest {

	@Test
	public void test() {
		Properties props = new Properties();
		try {
			props.load(PropertiesTest.class.getClassLoader().getResourceAsStream("jsf.properties"));
		} catch (Exception ex) {
			throw new RuntimeException("jsf.properties resource is not available");
		}
		Assert.assertEquals(props.getProperty("restful.server"), "http://localhost:8051/mf-restfull-server/mpfactory/");
		Assert.assertEquals(props.getProperty("restful.Cities"), "hello/citiesJson");
	}

}
