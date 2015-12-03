package com.omn.mpfactory.hibernate.counter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClassGeneratorMpFactory {

	private static String CLASS_NAME;
	private static int CLASS_COUNTER;
	private static int THREAD_COUNTER;
	private static String ROOT_NAME;

	public static String getClassName() {
		if (null == CLASS_NAME) {
			CLASS_COUNTER = 1;
			THREAD_COUNTER = 0;
			CLASS_NAME = getRootName() + CLASS_COUNTER;
		}else if(THREAD_COUNTER < 3){
			THREAD_COUNTER++;
		}else{
			THREAD_COUNTER = 0;
			CLASS_COUNTER++;
			CLASS_NAME = getRootName() + CLASS_COUNTER;
		}
		return CLASS_NAME;
	}

	private static String getRootName() {
		if (null == ClassGeneratorMpFactory.ROOT_NAME) {
			SimpleDateFormat formater = new SimpleDateFormat("yyMMddHHmmss_SSS");
			ClassGeneratorMpFactory.ROOT_NAME = "class_" + formater.format(new Date()) + "_";
		}
		return ClassGeneratorMpFactory.ROOT_NAME;
	}

}
