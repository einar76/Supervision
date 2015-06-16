package com.einar.supervision;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.einar.supervision.conf.SupervisionConfiguration;
import com.einar.supervision.indicator.Indicator;
import com.einar.supervision.service.IndicatorService;

@Component
public class DynamicIndicatorLauncher extends Thread {

	@Autowired
	List<Indicator> indicatorsToTest;

	@Autowired
	IndicatorService indicatorService;

	private int iteration = SupervisionConfiguration.getIterationConfiguration();
	private long waitingTimeForIndicator = SupervisionConfiguration.getWaitingTimeForIndicator();

	private static boolean started = false;
	private static boolean stop = false;

	public void cleanUp() {
		stop = true;
		started = false;
	}

	public void run() {

		if (started) {
			return;
		}
		started = true;

		for (int i = 0; !stop && (iteration <= 0 || i < iteration); i++) {
			for (final Indicator s : indicatorsToTest) {

				(new Thread() {
					public void run() {

						if (s.isDynamic()) {
							indicatorService.record(s.getId(), Integer.parseInt(s.getValue()));
						}

					}
				}).start();
			}

			try {
				Thread.sleep(waitingTimeForIndicator);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public long getWaitingTime() {
		return waitingTimeForIndicator;
	}

	public void setWaitingTime(long waitingTime) {
		this.waitingTimeForIndicator = waitingTime;
	}

}
