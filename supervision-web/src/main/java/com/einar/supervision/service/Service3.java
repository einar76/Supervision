package com.einar.supervision.service;

public class Service3 extends DefaultService implements TestableService {

	public long getId() {
		return 2;
	}

	public String getName() {
		return "LDAP";
	}
}
