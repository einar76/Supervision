package com.einar.supervision.indicator.impl;

import com.einar.supervision.indicator.Indicator;

public abstract class StaticIndicator implements Indicator {

	public abstract long getId();

	public abstract String getValue();

	public boolean isDynamic() {
		return false;
	}

	public abstract String getName();

}
