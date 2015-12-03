package com.omn.mpfactory.restfull.cities;

import java.util.List;

import org.springframework.stereotype.Component;

import com.omn.mpfactory.model.City;
import com.omn.mpfactory.transport.city.Cities;
import com.omn.mpfactory.transport.city.CityType;

@Component
public class CityRestfullHelper {

	public Cities getCitiesFromdb(List<City> cityList){
		Cities cities = new Cities();
		for(City city : cityList){
			cities.getCities().add(getCityType(city));
		}
		return cities;
	}
	
	public CityType getCityType(City city){
	    CityType ct = new CityType();
	    ct.setId(city.getId());
	    ct.setName(city.getName());
	    ct.setOrd(city.getOrd());
	    return ct;
	}
	
	public City getCity(long id, String name, long ord){
	    City city = new City();
	    city.setId(id);
	    city.setName(name);
	    city.setOrd(ord);
	    return city;
	}

}
