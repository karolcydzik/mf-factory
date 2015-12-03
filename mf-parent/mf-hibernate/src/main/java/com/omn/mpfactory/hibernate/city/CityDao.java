package com.omn.mpfactory.hibernate.city;

import java.util.List;

import com.omn.mpfactory.hibernate.generic.GenericDao;
import com.omn.mpfactory.model.City;

public interface CityDao extends GenericDao<City> {
	
	List<City> findByStateId(Long stateId);

}
