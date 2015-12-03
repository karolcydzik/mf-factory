package com.omn.mpfactory.jsf.search;

import java.util.List;

import com.omn.mpfactory.model.City;
import com.omn.mpfactory.model.District;
import com.omn.mpfactory.model.State;

public interface SearchFacade {

    List<State> getStates();

    List<City> findCitiesByState(Long stateId);

    List<City> findCitiesInAgglomeration(Long stateId);

    List<District> findDistrictsByCity(Long cityId);

    Boolean isDistrictInCity(Long cityId);

}
