package com.einar.supervision.indicator;

public interface Indicator {

	long getId();
	
	String getValue();
	
	boolean isDynamic();
	
	String getName();
	
}
