package com.omn.mpfactory.hibernate.agglomerations;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.omn.mpfactory.hibernate.generic.GenericDaoImpl;
import com.omn.mpfactory.model.AggloConnection;

@Repository("AggloConnectionDaoImpl")
public class AggloConnectionDaoImpl extends GenericDaoImpl<AggloConnection> implements AggloConnectionDao{
    
    public AggloConnectionDaoImpl() {
        super(AggloConnection.class);
    }

    public AggloConnectionDaoImpl(Class<AggloConnection> type) {
        super(AggloConnection.class);
    }

    private static Log LOG = LogFactory.getLog(AggloConnectionDaoImpl.class);

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<AggloConnection> findCitiesByAgglomerationId(Long agglomId) {
        LOG.debug("Start find cities by stateId.");
        Session session = getSessionFactory().getCurrentSession();
        List<AggloConnection> result = (List<AggloConnection>) session.createCriteria(persistentClass)
                .add(Restrictions.eq("aggloName.id", agglomId))
//                .addOrder(Order.asc("city.name"))
                .list();
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result;
    }

}
