package com.omn.mpfactory.restfull.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.omn.mpfactory.restfull.cities.CitiesRestfullService;
import com.omn.mpfactory.transport.city.Cities;
import com.omn.mpfactory.transport.city.CityType;

@Controller
@RequestMapping("/hello")
public class MpfactoryController {

	private CitiesRestfullService citiesRestfullService;

	@RequestMapping(
			method = RequestMethod.GET, 
			value = "/cities")
	public ModelAndView getCities() {
		Cities cities = citiesRestfullService.getCities();
		return new ModelAndView("cities", "cities", cities);
	}

	@RequestMapping(
			method = RequestMethod.GET,
	        value = "/citiesJson")
	@ResponseBody()
	public List<CityType> getCitiesJson() {
		Cities cities = citiesRestfullService.getCities();
		return cities.getCities();
	}

	@RequestMapping(
	        method = RequestMethod.GET,
	        value = "/firstCityJson")
	@ResponseBody()
	public CityType getFirstCityJson() {
		Cities cities = citiesRestfullService.getCities();
		return cities.getCities().get(0);
	}

	@RequestMapping(
	        method = RequestMethod.GET,
	        value = "/newCity")
	@ResponseBody()
	public ModelAndView getNewCity() {
		CityType city = new CityType();
		city.setId(-1);
		city.setName("NewName");
		city.setOrd(-1L);
		return new ModelAndView("newCity", "newCity", city);
	}

	@RequestMapping(
	        method = RequestMethod.POST,
	        value = "/createCity")
	@ResponseBody()
	public ModelAndView getCreateCity(
			HttpServletRequest request, 
	        @RequestParam(value="id", required=false) long id,
	        @RequestParam(value="name", required=false) String name,
	        @RequestParam(value="ord", required=false) long ord ) {
		CityType city = new CityType();
		city.setId(id);
		city.setName(name);
		city.setOrd(ord);
		return new ModelAndView("newCity", "newCity", city);
	}

	public void setCitiesRestfullService(
	        CitiesRestfullService citiesRestfullService) {
		this.citiesRestfullService = citiesRestfullService;
	}

}
