package com.omn.mpfactory.restfull.cities;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.omn.mpfactory.transport.city.Cities;
import com.omn.mpfactory.transport.city.CityType;

@Controller
@RequestMapping("/city")
public class CityController {
    
    private CitiesRestfullService citiesRestfullService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/cities")
    @ResponseBody()
    public List<CityType> getCitiesJson() {
        Cities cities = citiesRestfullService.getCities();
        return cities.getCities();
    }
    
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/cities/{id}")
    @ResponseBody()
    public CityType getCitiesJson(@PathVariable long id) {
        return citiesRestfullService.getCityById(id);
    }
    
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/newCity")
    @ResponseBody()
    public ModelAndView newCity() {
        CityType city = new CityType();
        city.setId(-1);
        city.setName("NewName");
        city.setOrd(-1L);
        return new ModelAndView("newCity", "newCity", city);
    }

    public void setCitiesRestfullService(CitiesRestfullService citiesRestfullService) {
        this.citiesRestfullService = citiesRestfullService;
    }
}
