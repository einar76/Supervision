package com.einar.supervision.indicator.impl.os;

import com.einar.supervision.indicator.impl.StaticIndicator;

public class OsArch extends StaticIndicator {

	@Override
	public long getId() {
		return 1102;
	}

	@Override
	public String getValue() {
		return System.getProperty("os.arch");
	}

	@Override
	public String getName() {
		return "OS_ARCH";
	}

}
