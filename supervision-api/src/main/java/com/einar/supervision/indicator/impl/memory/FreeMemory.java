package com.einar.supervision.indicator.impl.memory;

import com.einar.supervision.indicator.impl.DynamicIndicator;

public class FreeMemory extends DynamicIndicator {

	public long getId() {
		return 1002;
	}

	public String getValue() {
		int mb = 1024 * 1024;

		Runtime runtime = Runtime.getRuntime();

		return ""+(int) (runtime.freeMemory()) / mb;
	}

	public String getName() {
		return "FREE_MEMORY";
	}

}
