package com.omn.mpfactory.hibernate.dbload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class LoadDb {
	
	@Autowired
	LoadStates loadStates;

	@Autowired
	LoadCity loadCity;

	@Autowired
	LoadAgglo loadAgglo;
	
	public void loadDb(){
		loadStates.load();
		loadCity.load();
		loadAgglo.loadAgglomerations();
	}

}
