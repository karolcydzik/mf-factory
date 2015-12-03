package com.omn.mpfactory.hibernate.city.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omn.mpfactory.hibernate.city.CityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:com/omn/mpfactory/hibernate/city/service/ApplicationContext-IntegrationTest.xml"})
public class CityServiceImplIntegrationTest {
    
    @Autowired
    CityService service;

    @Test
    public void testFindAll() {
        Assert.assertNotNull(service.findAll());
    }
}
