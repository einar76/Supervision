package com.einar.supervision.indicator.impl.jvm;

import com.einar.supervision.indicator.impl.StaticIndicator;

public class JvmVendor extends StaticIndicator {

	@Override
	public long getId() {
		return 1201;
	}

	@Override
	public String getValue() {
		return System.getProperty("java.vendor");
	}

	@Override
	public String getName() {
		return "JVM_VENDOR";
	}

}
