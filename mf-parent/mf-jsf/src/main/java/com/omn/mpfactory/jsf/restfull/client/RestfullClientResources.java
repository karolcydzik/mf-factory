package com.omn.mpfactory.jsf.restfull.client;

import java.util.Properties;

public class RestfullClientResources {

	private static final String RestfullServer;
	public static final String CitiesURL;

	static {
		Properties props = new Properties();
		try {
			props.load(RestfullClientResources.class.getClassLoader().getResourceAsStream("jsf.properties"));
		} catch (Exception ex) {
			throw new RuntimeException("jsf.properties resource is not available");
		}
		RestfullServer = props.getProperty("restful.server");
		CitiesURL = RestfullServer + "/" + props.getProperty("restful.cities.url");
	}

}
