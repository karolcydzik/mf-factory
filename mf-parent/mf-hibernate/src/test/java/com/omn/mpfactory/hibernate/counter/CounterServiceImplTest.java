package com.omn.mpfactory.hibernate.counter;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.omn.mpfactory.hibernate.counter.CounterDao;
import com.omn.mpfactory.hibernate.counter.CounterServiceImpl;
import com.omn.mpfactory.hibernate.test.util.SampleBaseTestCase;

public class CounterServiceImplTest extends SampleBaseTestCase{
    
    @Mock private CounterDao counterDao;
    
    @InjectMocks private CounterServiceImpl counterService;
    
    @Before
    public void setUp() throws Exception {
    }

    @Ignore
    @Test
    public void testGetNextIdNullException() {
        String className="className";
        when(counterDao.getNexId(className)).thenThrow(new RuntimeException());
        Long id=counterService.getNextId(className);
        Assert.assertNull("Id should be null",id);
    }

}
