package com.omn.mpfactory.jsf.restfull.client;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CitiesClientTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetCitiesString() {
		String stTime;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
		stTime = sdf.format(new Date());
		StringBuilder sb = new StringBuilder();
		sb.append("\n XXXthis is the time:");
		sb.append(stTime).append("::");
		try {
			URL url;
			url = new URL("http://localhost:8051/mf-restfull-server/mpfactory/hello/citiesJson");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(50000);
			connection.setReadTimeout(50000);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String st = in.readLine();
			while (st != null) {
				sb.append(st);
				st = in.readLine();
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("\nError while calling REST Service");
			System.out.println("\nREST Service Invoked Successfully..");
			System.out.println(sb.toString());
			System.out.println(e);
			e.printStackTrace();
		}
		Assert.assertTrue(sb.length()>50);

	}

}
