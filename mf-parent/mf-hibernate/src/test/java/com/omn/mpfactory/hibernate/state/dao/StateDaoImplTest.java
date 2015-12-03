package com.omn.mpfactory.hibernate.state.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omn.mpfactory.hibernate.state.StateDao;
import com.omn.mpfactory.model.State;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext-hibernate.xml"})
public class StateDaoImplTest {
    
    @Autowired
    StateDao stateDao;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFindAll() {
        List<State>stateList = stateDao.findAll();
        Assert.assertNotNull(stateList);
    }

}
