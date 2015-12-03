package com.omn.mpfactory.hibernate.generic;

import java.util.List;

import com.omn.mpfactory.util.model.AbstractEntity;

public interface GenericService <T extends AbstractEntity> {

	/** Persist the newInstance object into database */
	void create(T newInstance);

	/** Save changes made to a persistent object. */
	void update(T transientObject);

	/** Remove an object from persistent storage in the database */
	void delete(T persistentObject);
	
	/** find by primary key **/ 
	T findById(Long pk);
	
	/** Find all **/
	List<T> findAll();
	
	void create(List<T> entityList);
}