package com.omn.mpfactory.hibernate.agglomerations;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omn.mpfactory.model.AggloConnection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext-hibernate.xml"})
public class AggloConnectionDaoImplTest {
    
    @Autowired
    AggloConnectionDao dao;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFindCitiesByAgglomerationId() {
        List<AggloConnection> aggloConnections = dao.findCitiesByAgglomerationId(1L);
        Assert.assertNotNull("Cities should not be null.", aggloConnections);
    }

}
