package com.omn.mpfactory.hibernate.dbload;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-hibernate.xml" })
public class LoadCityTest {
	
	 @Autowired
	 LoadCity loadCity;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Ignore
	@Test
	public void testLoad() {
		loadCity.load();
	}

}
