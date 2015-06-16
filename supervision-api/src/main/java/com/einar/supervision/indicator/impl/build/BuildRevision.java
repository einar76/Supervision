package com.einar.supervision.indicator.impl.build;

public class BuildRevision extends BuildVersion {

	@Override
	public long getId() {
		return 1303;
	}

	@Override
	public String getValue() {
		return readPropertie("Implementation-Revision");
	}

	@Override
	public String getName() {
		return "BUILD_REVISION";
	}

}
