package com.omn.mpfactory.hibernate.counter;


public interface CounterService {
	
	Long getNextId(String className);
	
}
