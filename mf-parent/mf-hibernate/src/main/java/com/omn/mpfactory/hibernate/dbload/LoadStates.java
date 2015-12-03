package com.omn.mpfactory.hibernate.dbload;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.omn.mpfactory.hibernate.state.StateDao;
import com.omn.mpfactory.model.State;

@Component()
public class LoadStates {

	@Autowired
	private StateDao dao;

	private List<State> states;

	public void load(){
		fillList();
		loadList();
	}
	
	
	private void loadList() {
		for(State state: states){
			dao.create(state);
		}
	}

	private void fillList() {
		states = new ArrayList<State>();
		states.add(new State(1L, "Dolnośląskie", null, null));
		states.add(new State(2L, "Kujawsko-Pomorskie", null, null));
		states.add(new State(3L, "Lubelskie", null, null));
		states.add(new State(4L, "Lubuskie", null, null));
		states.add(new State(5L, "Łódzkie", null, null));
		states.add(new State(6L, "Mazowieckie", null, null));
		states.add(new State(7L, "Małopolskie", null, null));
		states.add(new State(8L, "Opolskie", null, null));
		states.add(new State(9L, "Podkarpackie", null, null));
		states.add(new State(10L, "Podlaskie", null, null));
		states.add(new State(11L, "Pomorskie", null, null));
		states.add(new State(12L, "Śląskie", null, null));
		states.add(new State(13L, "Świętokrzyskie", null, null));
		states.add(new State(14L, "Warmińsko-Mazurskie", null, null));
		states.add(new State(15L, "Wielkopolskie", null, null));
		states.add(new State(16L, "Zachodniopomorskie", null, null));
	}
}
