package com.omn.mpfactory.hibernate.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.omn.mpfactory.hibernate.generic.GenericDao;
import com.omn.mpfactory.hibernate.generic.GenericServiceImpl;
import com.omn.mpfactory.model.City;

@Service
public class CityServiceImpl extends GenericServiceImpl<City> implements CityService{

    @Autowired
    CityDao cityDao;
    
    @Override
    public List<City> findAll() {
        List<City> cityList = cityDao.findAll();
        if(CollectionUtils.isEmpty(cityList)){
            return null;
        }
        return cityList;
    }

    @Override
    public List<City> findByStateId(Long stateId) {
        List<City> cityList = cityDao.findByStateId(stateId);
        if(CollectionUtils.isEmpty(cityList)){
            return null;
        }
        return cityList;
    }

    @Override
    public GenericDao<City> getGenericDao() {
        return cityDao;
    }

}
