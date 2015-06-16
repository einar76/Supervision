package com.einar.supervision.indicator.impl.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import com.einar.supervision.indicator.impl.StaticIndicator;

public class JvmUptime extends StaticIndicator {

	@Override
	public long getId() {
		return 1202;
	}

	@Override
	public String getValue() {

		RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
		long uptime = rb.getUptime();

		int weeks = (int) (uptime / (1000 * 60 * 60 * 24 * 7));
		uptime = uptime % (1000 * 60 * 60 * 24 * 7);
		int days = (int) ((uptime / (1000 * 60 * 60 * 24)) % 7);
		uptime = uptime % (1000 * 60 * 60 * 24);
		int hours = (int) ((uptime / (1000 * 60 * 60)) % 24);
		uptime = uptime % (1000 * 60 * 60);
		int minutes = (int) ((uptime / (1000 * 60)) % 60);
		uptime = uptime % (1000 * 60);
		int seconds = (int) ((uptime / (1000)) % 60);
		uptime = uptime % (1000);
		int milli = (int) uptime;

		String value = "";
		if (weeks>0) {
			value = String.format("%d weeks %d days",weeks, days);
		}
		else if (days>0) {
			value = String.format("%d days %d hours",days, hours);
		}
		else if (hours>0) {
			value = String.format("%d hours %d minutes",hours, minutes);
		}
		else if (minutes>0) {
			value = String.format("%d minutes %d seconds",minutes, seconds);
		}
		else {
			value = String.format("%d seconds %d milli",seconds, milli);
		}
		
		return value;
	}

	@Override
	public String getName() {
		return "JVM_UPTIME";
	}
	
}
