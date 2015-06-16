package com.einar.supervision.service;

public class Service2 extends DefaultService implements TestableService {

	public long getId() {
		return 1;
	}

	public String getName() {
		return "URL";
	}
}
