package com.omn.mpfactory.restfull.cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omn.mpfactory.hibernate.city.CityService;
import com.omn.mpfactory.model.City;
import com.omn.mpfactory.transport.city.Cities;
import com.omn.mpfactory.transport.city.CityType;

@Service()
public class CitiesRestfullServiceImpl implements CitiesRestfullService{

	@Autowired
	CityService cs;
	
	@Autowired
	CityRestfullHelper cityRestfullHelper;
	
	@Override
	public Cities getCities() {
		return cityRestfullHelper.getCitiesFromdb(cs.findAll());
	}

    @Override
    public void newCity(String name, long ord){
        City city = new City();
        city.setName(name);
        city.setOrd(ord);
        cs.create(city);
        
    }

    @Override
    public CityType getCityById(long id) {
        City city = cs.findById(id);
        return cityRestfullHelper.getCityType(city);
    }

    @Override
    public void updateCity(long id, String name, long ord) {
        cs.update(cityRestfullHelper.getCity(id, name, ord));
    }

    @Override
    public void deleteCity(long id) {
        cs.delete(cs.findById(id));
    }

}
