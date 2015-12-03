package com.omn.mpfactory.hibernate.district;

import java.util.List;

import com.omn.mpfactory.model.District;

public interface DistrictService{
    
    List<District> findByCityId(Long cityId);
    Boolean isDistrictInCity(Long cityId);

}
