package com.omn.mpfactory.hibernate.city.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omn.mpfactory.hibernate.city.CityDao;
import com.omn.mpfactory.model.City;

//@ContextConfiguration(locations = {"ApplicationContext-CityDaoImplTest.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:com/omn/mpfactory/hibernate/city/ApplicationContext-CityDaoImplTest.xml"})
public class CityDaoImplTest {
	
	@Autowired
	CityDao cityDao;
	
	@Test
	public void testFindByState() {
		List<City> cityList = cityDao.findByStateId(12L);
		Assert.assertNotNull("List should not be empty.", cityList);
	}

}
