package com.omn.mpfactory.hibernate.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.omn.mpfactory.hibernate.generic.GenericDao;
import com.omn.mpfactory.hibernate.generic.GenericServiceImpl;
import com.omn.mpfactory.model.State;

@Service
public class StateServiceImpl extends GenericServiceImpl<State> implements StateService {

    @Autowired
    @Qualifier("stateDao")
    StateDao stateDao;

    @Override
    public GenericDao<State> getGenericDao() {
        return stateDao;
    }
    
}
