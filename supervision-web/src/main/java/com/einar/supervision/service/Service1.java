package com.einar.supervision.service;

public class Service1 extends DefaultService implements TestableService {

	public long getId() {
		return 0;
	}

	public String getName() {
		return "JDBC";
	}
	
}
