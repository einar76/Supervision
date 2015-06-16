package com.einar.supervision.testable;

import java.util.Random;

import com.einar.supervision.exception.NotAliveException;
import com.einar.supervision.service.TestableService;

public class Service2 implements TestableService {

	public void isAlive() throws NotAliveException {
		int min = 0;
		int max = 300;
		int randomNum = new Random().nextInt((max - min) + 1) + min;
		
		try {
			Thread.sleep(randomNum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return;	
	}

	public long getId() {
		return 1;
	}
	
}
