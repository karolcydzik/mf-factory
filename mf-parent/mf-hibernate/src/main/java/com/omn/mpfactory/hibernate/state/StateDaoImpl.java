package com.omn.mpfactory.hibernate.state;

import org.springframework.stereotype.Repository;

import com.omn.mpfactory.hibernate.generic.GenericDaoImpl;
import com.omn.mpfactory.model.State;

@Repository("stateDao")
public class StateDaoImpl extends GenericDaoImpl<State> implements StateDao {
    
    public StateDaoImpl() {
        super(State.class);
    }
    
}
