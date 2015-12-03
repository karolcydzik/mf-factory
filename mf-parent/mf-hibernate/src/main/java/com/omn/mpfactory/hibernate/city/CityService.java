package com.omn.mpfactory.hibernate.city;

import java.util.List;

import com.omn.mpfactory.hibernate.generic.GenericService;
import com.omn.mpfactory.model.City;


public interface CityService extends GenericService<City>{

    List<City> findAll();
    List<City> findByStateId(Long stateId);
    
}
