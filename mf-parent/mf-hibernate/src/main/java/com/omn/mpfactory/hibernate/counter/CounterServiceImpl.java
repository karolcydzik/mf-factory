package com.omn.mpfactory.hibernate.counter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService {

	private static Log LOG = LogFactory.getLog(CounterServiceImpl.class);
	private static final int MAX_TRY_NUMBER = 50;

	@Autowired
	private CounterDao counterDao;

	@Override
	public synchronized Long getNextId(String className) {
		for (int i = 0; i < MAX_TRY_NUMBER; i++) {
			try {
				Long counterId = counterDao.getNexId(className);
				return counterId;
			} catch (Exception e) {
				LOG.debug(String.format("Read next id attempt=[%s], className=[%s].", i, className), e);
			}
		}
		LOG.error(String.format("Can not get new id for className=[%s].", className));
		return null;
	}

}
