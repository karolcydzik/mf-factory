package com.omn.mpfactory.hibernate.generic;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.omn.mpfactory.hibernate.util.CustomHibernateDaoSupport;
import com.omn.mpfactory.util.model.AbstractEntity;

public class GenericDaoImpl<T extends AbstractEntity> extends CustomHibernateDaoSupport implements GenericDao<T> {

    private static Log LOG = LogFactory.getLog(GenericDaoImpl.class);

    protected Class<T> persistentClass;

    public GenericDaoImpl(Class<T> type) {
        this.persistentClass = type;
    }

    @Transactional
    @Override
    public void create(T newInstance) {
        LOG.debug("Create new instance.");
        Session sf = getSessionFactory().getCurrentSession();
        sf.save(newInstance);
    }

    @Transactional
    @Override
    public void create(List<T> newInstance) {
        LOG.debug("Create list of new instances.");
        Session sf = getSessionFactory().getCurrentSession();
        for(T entity: newInstance ){
            sf.save(entity);
        }
    }

    @Transactional
    @Override
    public void update(T persistentObject) {
        LOG.debug("Update generic has been running.");
        getSessionFactory().getCurrentSession().update(persistentObject);
    }

    @Transactional
    @Override
    public void delete(T persistentObject) {
        LOG.debug("Delete generic has been running.");
        getSessionFactory().getCurrentSession().delete(persistentObject);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public T findById(Long pk) {
        LOG.debug("Start find by Id.");
        List<T> result = (List<T>) getSessionFactory().getCurrentSession().createCriteria(persistentClass).add(Restrictions.idEq(pk)).list();
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result.get(0);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<T> findAll() {
        LOG.debug("Find all.");
        List<T> result = (List<T>) getSessionFactory().getCurrentSession().createCriteria(persistentClass).list();
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result;
    }

}
