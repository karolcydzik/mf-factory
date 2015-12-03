package com.omn.mpfactory.hibernate.counter;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.omn.mpfactory.hibernate.generic.GenericDaoImpl;
import com.omn.mpfactory.model.Counter;

@Repository
public class CounterDaoImpl extends GenericDaoImpl<Counter> implements CounterDao {

    private static Log LOG = LogFactory.getLog(CounterDaoImpl.class);
    private static final Long START_NUMBER = 1L;

    public CounterDaoImpl() {
        super(Counter.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public Long getNexId(String className) {
        LOG.debug("Start getNextId.");
        Long nextId = START_NUMBER;
        Session session = getSessionFactory().getCurrentSession();
        session.buildLockRequest(LockOptions.UPGRADE);
        List<Counter> counterList = (List<Counter>) session.createCriteria(Counter.class).add(Restrictions.eq("className", className)).list();
        if (CollectionUtils.isEmpty(counterList)) {
            Long counterId = findMaxId(session);
            Counter counter = new Counter();
            counter.setClassName(className);
            counter.setId(++counterId);
            counter.setLastNumber(nextId);
            session.save(counter);
        } else {
            Counter counter = counterList.get(0);
            nextId = counter.getLastNumber();
            counter.setLastNumber(++nextId);
            session.update(counter);
        }
        return nextId;
    }

    @SuppressWarnings("unchecked")
    private Long findMaxId(Session session) {
        LOG.debug("ind Max id.");
        List<Long> list = (List<Long>) session.createCriteria(Counter.class).setProjection(Projections.max("id")).list();
        if (!CollectionUtils.isEmpty(list)) {
            Long id = list.get(0);
            if (id != null) {
                return id;
            }
        }
        return 0L;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public void deleteByName(String className) {
        Session session = getSessionFactory().getCurrentSession();
        List<Counter> counterList = (List<Counter>) session.createCriteria(Counter.class).add(Restrictions.eq("className", className)).list();
        if(CollectionUtils.isEmpty(counterList)){
            return;
        }
        for (Counter counter : counterList) {
            session.delete(counter);
        }
    }
}
