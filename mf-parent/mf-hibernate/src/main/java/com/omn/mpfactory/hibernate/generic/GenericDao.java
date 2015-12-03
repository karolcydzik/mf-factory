package com.omn.mpfactory.hibernate.generic;

import java.util.List;

import com.omn.mpfactory.util.model.AbstractEntity;

public interface GenericDao <T extends AbstractEntity> {

	/** Persist the newInstance object into database */
	void create(T newInstance);
	
    void create(List<T> newInstance);

	/** Save changes made to a persistent object. */
	void update(T persistentObject);

	/** Remove an object from persistent storage in the database */
	void delete(T persistentObject);
	
	/** find by primary key **/ 
	T findById(Long pk);
	
	/** find all **/ 
	List<T> findAll();
	
}