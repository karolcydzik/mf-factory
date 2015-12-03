package com.omn.mpfactory.hibernate.city;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.omn.mpfactory.hibernate.generic.GenericDaoImpl;
import com.omn.mpfactory.model.City;

@Repository
public class CityDaoImpl extends GenericDaoImpl<City> implements CityDao {

	public CityDaoImpl() {
		super(City.class);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<City> findByStateId(Long stateId) {
		List<City> list = (List<City>) getSessionFactory()
		        .getCurrentSession()
		        .createCriteria(City.class)
		        .addOrder(Order.asc("ord"))
		        .add(Restrictions.eq("state.id", stateId))
		        .list();
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list;
	}
	
}
