package com.omn.mpfactory.hibernate.dbload;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.omn.mpfactory.hibernate.agglomerations.AggloConnectionDao;
import com.omn.mpfactory.hibernate.agglomerations.AggloNameDao;
import com.omn.mpfactory.hibernate.city.CityDao;
import com.omn.mpfactory.model.AggloConnection;
import com.omn.mpfactory.model.AggloName;
import com.omn.mpfactory.model.City;
import com.omn.mpfactory.model.State;

@Component()
public class LoadAgglo {
	
    private static Log LOG = LogFactory.getLog(LoadAgglo.class);

	private List<Connection> connectionList;

	@Autowired
	private AggloNameDao aggloNameDao;

	@Autowired
	private AggloConnectionDao aggloConnectionDao;

	@Autowired
	private CityDao cityDao;
	
	public void loadAgglomerations(){
		loadNames();
		loadConnectionsList();
		loadAggloConnection();
	}

	private void loadNames() {
		State state = new State();
		state.setId(11L); // trojmiasto
		aggloNameDao.create(new AggloName(1L, state, "Trójmiasto", null));
		state.setId(12L); // Okręg katowicki
		aggloNameDao.create(new AggloName(2L, state, "Okręg katowicki", null));
	}
	
	private void loadAggloConnection(){
		for(Connection con : connectionList){
			aggloConnectionDao.create(getAggloConnection(con));
		}
	}
	
	private AggloConnection getAggloConnection(Connection con){
		AggloConnection ac = new AggloConnection();
		ac.setId(new Long(con.getId()));
		AggloName an = aggloNameDao.findById(new Long(con.getAgId()));
		if(an == null){
			LOG.error(String.format("Agglomeration has not been found for id=[$s]", con.getAgId()));
		}else{
			ac.setAggloName(an);
		}
		City city =cityDao.findById(new Long(con.getCityId()));
		if(city == null){
			LOG.error(String.format("City has not been found for id=[$s]", con.getAgId()));			
		}else{
			ac.setCity(city);
		}
		return ac;
	}

	private void loadConnectionsList() {
		connectionList = new ArrayList<Connection>();
		connectionList.add(new Connection(1, 1, 161));
		connectionList.add(new Connection(2, 1, 162));
		connectionList.add(new Connection(3, 1, 688));
		connectionList.add(new Connection(4, 2, 74));
		connectionList.add(new Connection(5, 2, 93));
		connectionList.add(new Connection(6, 2, 125));
		connectionList.add(new Connection(7, 2, 165));
		connectionList.add(new Connection(8, 2, 259));
		connectionList.add(new Connection(9, 2, 445));
		connectionList.add(new Connection(10, 2, 231));
		connectionList.add(new Connection(11, 2, 539));
		connectionList.add(new Connection(12, 2, 655));
		connectionList.add(new Connection(13, 2, 629));
		connectionList.add(new Connection(14, 2, 689));
		connectionList.add(new Connection(15, 2, 763));
		connectionList.add(new Connection(16, 2, 860));
	}

	private class Connection {
		private int id;
		private int agId;
		private int cityId;

		public Connection(int id, int agId, int cityId) {
			super();
			this.id = id;
			this.agId = agId;
			this.cityId = cityId;
		}

		public int getId() {
			return id;
		}

		public int getAgId() {
			return agId;
		}

		public int getCityId() {
			return cityId;
		}
	}
}
