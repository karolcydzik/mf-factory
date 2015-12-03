package com.omn.mpfactory.hibernate.agglomerations;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:com/omn/mpfactory/hibernate/agglomerations/ApplicationContext-IntegrationTest.xml"})
public class AggloNameDaoImplTest {
	
	@Autowired
	AggloNameDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Ignore
	@Test
	public void testFindCitiesInAgglomerationByAgglomerationId() {
		fail("Not yet implemented");
	}

}
