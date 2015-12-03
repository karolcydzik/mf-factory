package com.omn.mpfactory.restfull.cities;

import com.omn.mpfactory.transport.city.Cities;
import com.omn.mpfactory.transport.city.CityType;

public interface CitiesRestfullService {

    Cities getCities();

    void newCity(String name, long ord);

    CityType getCityById(long id);

    void updateCity(long id, String name, long ord);

    void deleteCity(long id);

}
