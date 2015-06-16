package com.einar.supervision.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SupervisionConfiguration {

	private int iteration = 0;
	private long waitingTimeForIndicator = 10000;
	private long waitingTimeForResource = 10000;

	private static SupervisionConfiguration me;

	private static SupervisionConfiguration singleton() {

		if (me == null) {
			me = new SupervisionConfiguration();
		}
		return me;
	}

	private SupervisionConfiguration() {

		Properties prop = new Properties();

		String filename = "supervision.properties";
		InputStream input = SupervisionConfiguration.class.getClassLoader().getResourceAsStream(filename);
		if (input != null) {
			try {
				prop.load(input);
				if (prop.getProperty("iteration") != null && prop.getProperty("waitingTimeForIndicator") != null && prop.getProperty("waitingTimeForResource") != null) {
					setIteration(Integer.valueOf(prop.getProperty("iteration")));
					setWaitingTimeForIndicator(Long.valueOf(prop.getProperty("waitingTimeForIndicator")));
					setWaitingTimeForResource(Long.valueOf(prop.getProperty("waitingTimeForResource")));
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	private int getIteration() {
		return iteration;
	}

	private void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public static long getWaitingTimeForIndicator() {
		return singleton().waitingTimeForIndicator;
	}

	public void setWaitingTimeForIndicator(long waitingTimeForIndicator) {
		this.waitingTimeForIndicator = waitingTimeForIndicator;
	}

	public static long getWaitingTimeForResource() {
		return singleton().waitingTimeForResource;
	}

	public void setWaitingTimeForResource(long waitingTimeForResource) {
		this.waitingTimeForResource = waitingTimeForResource;
	}

	public static int getIterationConfiguration() {
		return singleton().getIteration();
	}

}
