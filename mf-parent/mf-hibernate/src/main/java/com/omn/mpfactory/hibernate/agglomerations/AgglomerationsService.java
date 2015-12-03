package com.omn.mpfactory.hibernate.agglomerations;

import java.util.List;

import com.omn.mpfactory.model.AggloName;
import com.omn.mpfactory.model.City;

public interface AgglomerationsService {

    AggloName findAgglomerationByStateId(Long stateId);
    
    List<City> findCitiesInAgglomerationByAgglomerationId(Long cityId);
    
}
