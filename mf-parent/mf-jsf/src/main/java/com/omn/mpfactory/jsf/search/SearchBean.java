package com.omn.mpfactory.jsf.search;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "searchBean", eager = true)
@SessionScoped
public class SearchBean {

    private Long stateId;
    private Long cityId;
    private Long agglomerationCityId;
    private Long agglomerationId;
    private Long districtId;

    public void changedState(ValueChangeEvent event) {
        stateId = (Long) event.getNewValue();
        cityId = null;
        agglomerationId = null;
        districtId = null;
        agglomerationCityId = null;
    }

    public void changedCity(ValueChangeEvent event) {
        cityId = (Long) event.getNewValue();
        if (cityId < 0) {
            agglomerationId = cityId;
        } else {
            agglomerationId = null;
        }
        agglomerationCityId = null;
        districtId = null;
    }

    public void changedAgglomeration(ValueChangeEvent event) {
        agglomerationCityId = (Long) event.getNewValue();
        districtId = null;
    }

    public void changedDistrict(ValueChangeEvent event) {
        agglomerationCityId = (Long) event.getNewValue();
        districtId = null;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getAgglomerationId() {
        return agglomerationId;
    }

    public void setAgglomerationId(Long agglomerationId) {
        this.agglomerationId = agglomerationId;
    }

    public Long getAgglomerationCityId() {
        return agglomerationCityId;
    }

    public void setAgglomerationCityId(Long agglomerationCityId) {
        this.agglomerationCityId = agglomerationCityId;
    }

}
