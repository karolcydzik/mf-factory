package com.omn.mpfactory.jsf.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.omn.mpfactory.hibernate.agglomerations.AgglomerationsService;
import com.omn.mpfactory.hibernate.city.CityService;
import com.omn.mpfactory.hibernate.district.DistrictService;
import com.omn.mpfactory.hibernate.state.StateService;
import com.omn.mpfactory.model.AggloName;
import com.omn.mpfactory.model.City;
import com.omn.mpfactory.model.District;
import com.omn.mpfactory.model.State;

@Component("searchFacade")
@Scope("globalSession")
public class SearchFacadeImpl implements SearchFacade {
    
    private static final String WHOLE_STATE = "Całe województwo";

    @Autowired
    private StateService stateService;
    @Autowired
    private CityService cityService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private AgglomerationsService agglomerationsService;
    @Autowired

    
    @Override
    public List<State> getStates() {
        return stateService.findAll();
    }

    @Override
    public List<City> findCitiesByState(Long stateId) {
        if (null == stateId || stateId == 0) {
            return null;
        }
        List<City> cityList = new ArrayList<City>(0);
        cityList.add(getCityiesHeader());
        
        
        checkAgglomeration(cityList, stateId);
        cityList.addAll(cityService.findByStateId(stateId));
        return cityList;
    }
    
    private void checkAgglomeration(List<City>cityList, Long stateId){
        AggloName aggloName = agglomerationsService.findAgglomerationByStateId(stateId);
        if(aggloName == null){
            return;
        }
        cityList.add(getAgglomeration(aggloName));
    }
    
    private City getAgglomeration(AggloName an){
        City city = new City();
        city.setName(an.getName());
        // City with negative id is agglomeration
        city.setId(-an.getId());
        return city;
    }
    
    private City getCityiesHeader(){
        City city = new City();
        city.setName(WHOLE_STATE);
        return city;
    }

    @Override
    public List<District> findDistrictsByCity(Long cityId) {
        if (null == cityId || cityId == 0) {
            return null;
        }
        List<District> districtList = districtService.findByCityId(cityId);
        if (CollectionUtils.isEmpty(districtList)) {
            return null;
        }
        return districtList;
    }

    @Override
    public List<City> findCitiesInAgglomeration(Long cityId) {
        return agglomerationsService.findCitiesInAgglomerationByAgglomerationId(-cityId);
    }

    @Override
    public Boolean isDistrictInCity(Long cityId) {
        if(null == cityId){
            return false;
        }
        return districtService.isDistrictInCity(cityId);
    }

}
