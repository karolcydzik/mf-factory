package com.omn.mpfactory.hibernate.counter;

import com.omn.mpfactory.hibernate.generic.GenericDao;
import com.omn.mpfactory.model.Counter;

public interface CounterDao extends GenericDao<Counter>{
	
    Long getNexId(String className);

    void deleteByName(String className);

}
