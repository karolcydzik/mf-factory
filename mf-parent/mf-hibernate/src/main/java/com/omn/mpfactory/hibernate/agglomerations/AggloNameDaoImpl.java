package com.omn.mpfactory.hibernate.agglomerations;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.omn.mpfactory.hibernate.generic.GenericDaoImpl;
import com.omn.mpfactory.model.AggloConnection;
import com.omn.mpfactory.model.AggloName;
import com.omn.mpfactory.model.City;

@Repository()
public class AggloNameDaoImpl extends GenericDaoImpl<AggloName> implements AggloNameDao{
    
    private static Log LOG = LogFactory.getLog(AggloNameDaoImpl.class);

    public AggloNameDaoImpl() {
        super(AggloName.class);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<City> findCitiesInAgglomerationByAgglomerationId(Long agglomId) {
        LOG.debug("Start find cities by stateId.");
        Session session = getSessionFactory().getCurrentSession();
        List<AggloName> result = (List<AggloName>) session.createCriteria(persistentClass)
                .add(Restrictions.eq("id", agglomId))
                .list();
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return getCityList(result.get(0));
    }
    
    private List<City> getCityList(AggloName agglo){
        List<City> cities = new ArrayList<City>(0);
        for (AggloConnection con : agglo.getAggloConnections()) {
            City city = con.getCity();
            Hibernate.initialize(city);
            cities.add(city);
        }
        return cities;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public AggloName findAgglomerationByStateId(Long stateId) {
        LOG.debug("Start find agglomeration by stateId.");
        Session session = getSessionFactory().getCurrentSession();
        List<AggloName> result = (List<AggloName>) session.createCriteria(persistentClass).add(Restrictions.eq("state.id", stateId)).list();
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        AggloName aggloName = result.get(0);
        Hibernate.initialize(aggloName);
        for(AggloConnection aConnection:aggloName.getAggloConnections()){
            Hibernate.initialize(aConnection);
            Hibernate.initialize(aConnection.getCity());
        }
        return aggloName;
    }
    
}
