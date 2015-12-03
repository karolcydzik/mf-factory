package com.omn.mpfactory.jsf.restfull.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.omn.mpfactory.transport.city.Cities;

@ManagedBean(name = "citiesClient", eager = true)
@SessionScoped
public class CitiesClient {

	private Cities cities = null;

	public Cities getCities() {
		if (cities == null) {
			URL url;
			try {
				url = new URL(RestfullClientResources.CitiesURL);
				JAXBContext jaxbContext = JAXBContext.newInstance(Cities.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				cities = (Cities) jaxbUnmarshaller.unmarshal(url);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
		return cities;
	}

}
