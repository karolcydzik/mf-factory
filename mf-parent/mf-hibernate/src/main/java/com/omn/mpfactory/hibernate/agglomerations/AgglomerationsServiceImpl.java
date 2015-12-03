package com.omn.mpfactory.hibernate.agglomerations;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omn.mpfactory.model.AggloName;
import com.omn.mpfactory.model.City;

@Service
public class AgglomerationsServiceImpl implements AgglomerationsService {

    @Autowired
    AggloNameDao dao;

    @Override
    public AggloName findAgglomerationByStateId(Long stateId) {
        return dao.findAgglomerationByStateId(stateId);
    }

    @Override
    public List<City> findCitiesInAgglomerationByAgglomerationId(Long agglomId) {
        List<City> cities = dao.findCitiesInAgglomerationByAgglomerationId(agglomId);
        Collections.sort(cities, new Comparator<City>() {
            public int compare(City c1, City c2) {
                //Sorts by 'TimeStarted' property
                return c1.getOrd()<c2.getOrd()?-1:c1.getOrd()>c2.getOrd()?1:doSecodaryOrderSort(c1,c2);
            }

            //If 'TimeStarted' property is equal sorts by 'TimeEnded' property
            public int doSecodaryOrderSort(City o1,City o2) {
                return o1.getOrd()<o2.getOrd()?-1:o1.getOrd()>o2.getOrd()?1:0;
            }
        });
        return cities;
    }
    
}