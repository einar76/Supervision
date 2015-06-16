package com.einar.supervision.service;

import java.util.Random;

import com.einar.supervision.exception.NotAliveException;

public abstract class DefaultService {

	public void isAlive() throws NotAliveException {
		
		int min = 0;
		int max = 1000;
		int randomNum = new Random().nextInt((max - min) + 1) + min;

		if (randomNum%111==0) {
			throw new NotAliveException();
		}
		
		try {
			Thread.sleep(randomNum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		return;		
	}
	
	public abstract long getId();
	
}
