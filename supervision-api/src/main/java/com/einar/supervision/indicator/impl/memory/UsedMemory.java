package com.einar.supervision.indicator.impl.memory;

import com.einar.supervision.indicator.impl.DynamicIndicator;

public class UsedMemory extends DynamicIndicator {

	public long getId() {
		return 1000;
	}

	public String getValue() {
		int mb = 1024 * 1024;

		Runtime runtime = Runtime.getRuntime();

		return ""+(int) (runtime.totalMemory() - runtime.freeMemory()) / mb;
	}

	public String getName() {
		return "USED_MEMORY";
	}

}
