package com.einar.supervision.indicator.impl.build;

public class BuildDate extends BuildVersion {

	@Override
	public long getId() {
		return 1302;
	}

	@Override
	public String getValue() {
		return readPropertie("Implementation-Timestamp");
	}

	@Override
	public String getName() {
		return "BUILD_DATE";
	}

}
