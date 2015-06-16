package com.einar.supervision.service;

import com.einar.supervision.exception.NotAliveException;

public interface TestableService {

	void isAlive() throws NotAliveException;
	
	long getId();
	
	String getName();
	
}
