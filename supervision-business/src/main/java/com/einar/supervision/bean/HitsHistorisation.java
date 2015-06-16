package com.einar.supervision.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class SessionsHistorisation.
 */
public class HitsHistorisation {

	/** The max. */
	private long max;
	
	/** The avg. */
	private float avg;
	
	/** The interval. */
	private long interval;

	/** The creations. */
	private Map<Long, Integer> ok = new HashMap<Long, Integer>();
	
	/** The destructions. */
	private Map<Long, Integer> ko = new HashMap<Long, Integer>();

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
	public Map<Long, Integer> getOks() {
		return ok;
	}

	/**
	 * Gets the destructions.
	 *
	 * @return the destructions
	 */
	public Map<Long, Integer> getKos() {
		return ko;
	}

	/**
	 * Adds the creation.
	 *
	 * @param interval the interval
	 */
	public void addOk(long interval) {

		if (ok.get(interval) == null) {
			ok.put(interval, 1);
		} else {
			ok.put(interval, ok.get(interval) + 1);
		}
	}

	/**
	 * Adds the destruction.
	 *
	 * @param interval the interval
	 */
	public void addKo(long interval) {

		if (ko.get(interval) == null) {
			ko.put(interval, 1);
		} else {
			ko.put(interval, ko.get(interval) + 1);
		}
	}
	
	public void init(long interval) {

		ok.put(interval, 0);
		ko.put(interval, 0);
		
	}
	
}
