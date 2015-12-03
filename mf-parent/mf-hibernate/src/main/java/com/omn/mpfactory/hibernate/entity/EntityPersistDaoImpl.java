package com.omn.mpfactory.hibernate.entity;

import org.springframework.stereotype.Repository;

import com.omn.mpfactory.hibernate.generic.GenericDaoImpl;
import com.omn.mpfactory.util.model.AbstractEntity;

@Repository
public class EntityPersistDaoImpl extends GenericDaoImpl<AbstractEntity> implements EntityPersistDao {

    public EntityPersistDaoImpl() {
        super(AbstractEntity.class);
    }

    public EntityPersistDaoImpl(Class<AbstractEntity> type) {
        super(type);
    }

}
