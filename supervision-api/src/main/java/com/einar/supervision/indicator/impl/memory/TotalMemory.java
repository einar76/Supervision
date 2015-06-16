package com.einar.supervision.indicator.impl.memory;

import com.einar.supervision.indicator.impl.DynamicIndicator;

public class TotalMemory extends DynamicIndicator {

	public long getId() {
		return 1001;
	}

	public String getValue() {
		int mb = 1024 * 1024;

		Runtime runtime = Runtime.getRuntime();

		return ""+(int) (runtime.totalMemory()) / mb;
	}

	public String getName() {
		return "TOTAL_MEMORY";
	}

}
