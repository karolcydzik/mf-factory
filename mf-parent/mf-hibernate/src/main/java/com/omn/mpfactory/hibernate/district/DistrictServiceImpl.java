package com.omn.mpfactory.hibernate.district;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omn.mpfactory.model.District;

@Service
public class DistrictServiceImpl implements DistrictService{

    @Autowired
    DistrictDao districtDao;
    
    @Override
    public List<District> findByCityId(Long cityId) {
        return districtDao.findDistrictListByCityId(cityId);
    }

    @Override
    public Boolean isDistrictInCity(Long cityId) {
        return districtDao.isDistrictInCity(cityId);
    }

}
