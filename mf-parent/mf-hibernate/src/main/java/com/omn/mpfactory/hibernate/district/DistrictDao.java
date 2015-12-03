package com.omn.mpfactory.hibernate.district;

import java.util.List;

import com.omn.mpfactory.hibernate.generic.GenericDao;
import com.omn.mpfactory.model.District;

public interface DistrictDao extends GenericDao<District> {
    
    List<District> findDistrictListByCityId(Long cityId);
    Boolean isDistrictInCity(Long cityId);
    
}
