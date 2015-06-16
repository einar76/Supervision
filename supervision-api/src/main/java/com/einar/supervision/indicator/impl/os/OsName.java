package com.einar.supervision.indicator.impl.os;

import com.einar.supervision.indicator.impl.StaticIndicator;

public class OsName extends StaticIndicator {

	@Override
	public long getId() {
		return 1100;
	}

	@Override
	public String getValue() {
		return System.getProperty("os.name");
	}

	@Override
	public String getName() {
		return "OS_NAME";
	}

}
