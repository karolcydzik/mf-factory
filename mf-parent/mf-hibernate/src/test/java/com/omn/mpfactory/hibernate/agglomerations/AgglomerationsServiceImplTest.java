package com.omn.mpfactory.hibernate.agglomerations;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omn.mpfactory.model.AggloName;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:com/omn/mpfactory/hibernate/agglomerations/ApplicationContext-IntegrationTest.xml"})
public class AgglomerationsServiceImplTest {
    
    @Autowired
    AgglomerationsService service;

    @Ignore
    @Test
    public void testFindCitiesByStateId() {
        AggloName aggloName = service.findAgglomerationByStateId(1L);
        assertNotNull("Agglomeration should not be null.", aggloName);
        assertNotNull("Name should not be null.", aggloName.getName());
        //TODO should check cities.
    }

}
