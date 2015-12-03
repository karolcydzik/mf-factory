package com.omn.mpfactory.hibernate.agglomerations;

import java.util.List;

import com.omn.mpfactory.model.AggloName;
import com.omn.mpfactory.model.City;

public interface AggloNameDao {

    List<City> findCitiesInAgglomerationByAgglomerationId(Long agglomId);
    AggloName findAgglomerationByStateId(Long stateId);
    
    void create(AggloName aggloName);
    AggloName findById(Long id);
}
