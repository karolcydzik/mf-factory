package com.omn.mpfactory.hibernate.counter;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omn.mpfactory.hibernate.city.CityDao;
import com.omn.mpfactory.hibernate.counter.CounterService;
import com.omn.mpfactory.hibernate.state.StateDao;
import com.omn.mpfactory.model.State;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:com/omn/mpfactory/hibernate/counter/ApplicationContext-CounterServiceImplGetNextIdTest.xml" })
public class CounterServiceImplGetNextIdTest {

	private static Log LOG = LogFactory.getLog(CounterServiceImplGetNextIdTest.class);

	public static String THREAD_NAME = "tr1";

	@Autowired
	CounterService service;
	@Autowired
	StateDao dao;
	@Autowired
	CityDao cityDao;

	/**
	 * Propose of this test is check if @Transactional is working correctly.
	 * this test should be running simultaneously in few treads.
	 * 
	 * @throws InterruptedException
	 */
	// @Ignore
	@Test
	public void testGetNextId() {
		LOG.info("Start test.");
		String threadName = "tr1";
		Thread t1 = getClassRunner(threadName);
		t1.run();
//		Thread t2 = getClassRunner("tr2");
//		t2.run();
//		Thread t3 = getClassRunner("tr3");
//		t3.run();
//		Thread t4 = getClassRunner("tr4");
//		t4.run();
//		try {
//			THREAD_NAME.wait();
//		} catch (InterruptedException e) {
//			LOG.info("Time to clean up table.");
//		}
		cleanUpTable();
	}

	private void cleanUpTable() {
		List<State> stateList = dao.findAll();
		for (State state : stateList) {
			if (state.getId() > 99) {
				dao.delete(state);
			}
		}
	}

	private Thread getClassRunner(String name) {
		ClassRunner cr = new ClassRunner();
		cr.setService(service);
		cr.setStateDao(dao);
		cr.setThreadName(name);
		return new Thread(cr);
	}

}
