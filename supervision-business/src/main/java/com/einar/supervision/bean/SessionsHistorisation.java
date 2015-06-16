package com.einar.supervision.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class SessionsHistorisation.
 */
public class SessionsHistorisation {

	/** The max. */
	private long max;
	
	/** The avg. */
	private float avg;
	
	/** The interval. */
	private long interval;

	/** The creations. */
	private Map<Long, Integer> creations = new HashMap<Long, Integer>();
	
	/** The destructions. */
	private Map<Long, Integer> destructions = new HashMap<Long, Integer>();

	/**
	 * Gets the avg.
	 *
	 * @return the avg
	 */
	public float getAvg() {
		return avg;
	}

	/**
	 * Sets the avg.
	 *
	 * @param avg the new avg
	 */
	public void setAvg(float avg) {
		this.avg = avg;
	}

	/**
	 * Gets the max.
	 *
	 * @return the max
	 */
	public long getMax() {
		return max;
	}

	/**
	 * Sets the max.
	 *
	 * @param max the new max
	 */
	public void setMax(long max) {
		this.max = max;
	}

	/**
	 * Gets the interval.
	 *
	 * @return the interval
	 */
	public long getInterval() {
		return interval;
	}

	/**
	 * Sets the interval.
	 *
	 * @param interval the new interval
	 */
	public void setInterval(long interval) {
		this.interval = interval;
	}

	/**
	 * Gets the creations.
	 *
	 * @return the creations
	 */
	public Map<Long, Integer> getCreations() {
		return creations;
	}

	/**
	 * Gets the destructions.
	 *
	 * @return the destructions
	 */
	public Map<Long, Integer> getDestructions() {
		return destructions;
	}

	/**
	 * Adds the creation.
	 *
	 * @param interval the interval
	 */
	public void addCreation(long interval) {

		if (creations.get(interval) == null) {
			creations.put(interval, 1);
		} else {
			creations.put(interval, creations.get(interval) + 1);
		}
	}

	/**
	 * Adds the destruction.
	 *
	 * @param interval the interval
	 */
	public void addDestruction(long interval) {

		if (destructions.get(interval) == null) {
			destructions.put(interval, 1);
		} else {
			destructions.put(interval, destructions.get(interval) + 1);
		}
	}
	
	public void init(long interval) {

		creations.put(interval, 0);
		destructions.put(interval, 0);
		
	}
	
}
