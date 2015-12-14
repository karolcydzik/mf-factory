package com.omn.mpfactory.restfull.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Ignore;
//import org.json.JSONObject;
import org.junit.Test;

public class MpfactoryControllerTest {

	@Test
	@Ignore
	public void testGetCitiesJson() {
		 String string = "";
	        try {
	 
	            // Step1: Let's 1st read file from fileSystem
	            InputStream crunchifyInputStream = new FileInputStream(
	                    "src/test/resources/jsonFile.txt");
	            InputStreamReader crunchifyReader = new InputStreamReader(crunchifyInputStream);
	            BufferedReader br = new BufferedReader(crunchifyReader);
	            String line;
	            while ((line = br.readLine()) != null) {
	                string += line + "\n";
	            }
	 
	            JSONObject jsonObject = new JSONObject(string);
	            System.out.println(jsonObject);
	 
	            // Step2: Now pass JSON File Data to REST Service
	            try {
	                URL url = new URL("http://localhost:8051/mf-restfull-server/mpfactory/hello/citiesJson");
	                URLConnection connection = url.openConnection();
	                connection.setDoOutput(true);
	                connection.setRequestProperty("Content-Type", "application/json");
	                connection.setConnectTimeout(50000);
	                connection.setReadTimeout(50000);
	                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
	                out.write(jsonObject.toString());
	                out.close();
	 
	                BufferedReader in = new BufferedReader(new InputStreamReader(
	                        connection.getInputStream()));
	                
	                StringBuilder sb = new StringBuilder();
	                String st = in.readLine();
	                while (st != null) {
	                	sb.append(st);
	                	st = in.readLine();	                		     
	                }
	                System.out.println("\nREST Service Invoked Successfully..");
	                System.out.println(sb.toString());
	                in.close();
	            } catch (Exception e) {
	                System.out.println("\nError while calling REST Service");
	                System.out.println(e);
	                e.printStackTrace();
	            }
	 
	            br.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
