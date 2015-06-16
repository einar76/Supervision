package com.einar.supervision;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.einar.supervision.conf.SupervisionConfiguration;
import com.einar.supervision.exception.NotAliveException;
import com.einar.supervision.service.ResourceService;
import com.einar.supervision.service.TestableService;

@Component
public class TestableServiceLauncher extends Thread {

	@Autowired
	List<TestableService> servicesToTest;

	@Autowired
	ResourceService resourceService;

	private int iteration = SupervisionConfiguration.getIterationConfiguration();
	private long waitingTime = SupervisionConfiguration.getWaitingTimeForResource();

	private static boolean started = false;
	private static boolean stop = false;
	
	public void cleanUp() {
		stop = true;
		started=false;
	}
	
	public void run() {

		if (started) {
			return;
		}
		started=true;
		
		for (int i = 0; !stop && (iteration <= 0 || i < iteration); i++) {
			for (final TestableService s : servicesToTest) {

				(new Thread() {
					public void run() {

						long start = System.currentTimeMillis();
						try {

							s.isAlive();

							resourceService.record(s.getId(), System.currentTimeMillis() - start, true, "", s.getName());

						} catch (NotAliveException e) {
							resourceService.record(s.getId(), System.currentTimeMillis() - start, false, e.getMessage(), s.getName());
						}

					}
				}).start();
			}

			try {
				Thread.sleep(waitingTime);
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
		return waitingTime;
	}

	public void setWaitingTime(long waitingTime) {
		this.waitingTime = waitingTime;
	}

}
