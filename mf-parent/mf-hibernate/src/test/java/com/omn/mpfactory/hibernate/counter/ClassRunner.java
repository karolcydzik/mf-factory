package com.omn.mpfactory.hibernate.counter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.omn.mpfactory.hibernate.counter.CounterService;
import com.omn.mpfactory.hibernate.state.StateDao;
import com.omn.mpfactory.model.State;

public class ClassRunner implements Runnable {

	private static Log LOG = LogFactory.getLog(ClassRunner.class);

	private CounterService service;
	private StateDao stateDao;

	private String threadName;

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			String className = ClassGeneratorMpFactory.getClassName();
			Long stateId = getStateId();
			LOG.info(String.format("thread=[%s], className=[%s], nextId=[%s]", threadName, className, stateId));
			State state = new State();
			state.setName("StateToDelete"+i);
			state.setId(stateId);
			stateDao.create(state);
		}
//		CounterServiceImplTest.THREAD_NAME.notify();
	}

	/**
	 * State is never added in program.
	 * This only for test proposes.
	 * States with id>100 should be deleted.
	 */
	private Long getStateId(){
		for (int i = 0; i < 101; i++) {
			Long stateId = service.getNextId(State.class.getName());
			if(stateId>99){
				return stateId;
			}
        }
		throw new RuntimeException("Generating index error.");
	}
	public void setService(CounterService service) {
		this.service = service;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public void setStateDao(StateDao stateDao) {
		this.stateDao = stateDao;
	}

}
