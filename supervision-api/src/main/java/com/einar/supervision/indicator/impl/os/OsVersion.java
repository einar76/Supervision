package com.einar.supervision.indicator.impl.os;

import com.einar.supervision.indicator.impl.StaticIndicator;

public class OsVersion extends StaticIndicator {

	@Override
	public long getId() {
		return 1101;
	}

	@Override
	public String getValue() {
		return System.getProperty("os.version");
	}

	@Override
	public String getName() {
		return "OS_VERSION";
	}

}
