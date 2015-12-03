package com.omn.mpfactory.hibernate.generic;

import java.util.List;

import com.omn.mpfactory.util.model.AbstractEntity;

public abstract class GenericServiceImpl<T extends AbstractEntity> implements GenericService<T> {

    public abstract GenericDao<T> getGenericDao();

    @Override
    public void create(T newInstance) {
        getGenericDao().create(newInstance);
    }

    @Override
    public void update(T updateObject) {
        getGenericDao().update(updateObject);
    }

    @Override
    public void delete(T persistentObject) {
        getGenericDao().delete(persistentObject);
    }

    @Override
    public T findById(Long pk) {
        return getGenericDao().findById(pk);
    }

    @Override
    public List<T> findAll() {
        return getGenericDao().findAll();
    }

    @Override
    public void create(List<T> entityList) {
        // TODO Auto-generated method stub

    }

}
