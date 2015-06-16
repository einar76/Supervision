package com.einar.supervision.indicator.impl.jvm;

import com.einar.supervision.indicator.impl.StaticIndicator;

public class JvmVersion extends StaticIndicator {

	@Override
	public long getId() {
		return 1200;
	}

	@Override
	public String getValue() {
		return System.getProperty("java.version");
	}

	@Override
	public String getName() {
		return "JVM_VERSION";
	}

}
