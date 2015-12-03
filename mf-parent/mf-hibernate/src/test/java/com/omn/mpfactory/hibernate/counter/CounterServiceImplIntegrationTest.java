package com.omn.mpfactory.hibernate.counter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omn.mpfactory.hibernate.counter.CounterDao;
import com.omn.mpfactory.hibernate.counter.CounterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:com/omn/mpfactory/hibernate/counter/ApplicationContext-integration.xml" })
public class CounterServiceImplIntegrationTest {
    
    @Autowired
    CounterDao counterDao;
    @Autowired
    CounterService counterService;

    @Test
    public void testGetNextId() {
        String className = getClassName();
        Long id = counterService.getNextId(className);
        Assert.assertEquals(1L, id.longValue());
        id = counterService.getNextId(className);
        Assert.assertEquals(2L, id.longValue());
        counterDao.deleteByName(className);
    }
    
    private String getClassName(){
        SimpleDateFormat formater = new SimpleDateFormat("yyMMddHHmmss_SSS");
        return "CSJT_" + formater.format(new Date());
    }

}
