package com.einar.supervision.bean;

/**
 * The Class ExecutionStats.
 */
public class ExecutionStats {

	/** The nb call. */
	private long nbCall;

	/** The total time. */
	private long totalTime;

	/** The min time. */
	private long minTime;

	/** The max time. */
	private long maxTime;

	/** The avg time. */
	private double avgTime;

	/**
	 * Gets the nb call.
	 * 
	 * @return the nb call
	 */
	public long getNbCall() {
		return nbCall;
	}

	/**
	 * Sets the nb call.
	 * 
	 * @param nbCall
	 *            the new nb call
	 */
	public void setNbCall(long nbCall) {
		this.nbCall = nbCall;
	}

	/**
	 * Gets the total time.
	 * 
	 * @return the total time
	 */
	public long getTotalTime() {
		return totalTime;
	}

	/**
	 * Sets the total time.
	 * 
	 * @param totalTime
	 *            the new total time
	 */
	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	/**
	 * Gets the min time.
	 * 
	 * @return the min time
	 */
	public long getMinTime() {
		return minTime;
	}

	/**
	 * Sets the min time.
	 * 
	 * @param minTime
	 *            the new min time
	 */
	public void setMinTime(long minTime) {
		this.minTime = minTime;
	}

	/**
	 * Gets the max time.
	 * 
	 * @return the max time
	 */
	public long getMaxTime() {
		return maxTime;
	}

	/**
	 * Sets the max time.
	 * 
	 * @param maxTime
	 *            the new max time
	 */
	public void setMaxTime(long maxTime) {
		this.maxTime = maxTime;
	}

	/**
	 * Gets the avg time.
	 * 
	 * @return the avg time
	 */
	public double getAvgTime() {
		return avgTime;
	}

	/**
	 * Sets the avg time.
	 * 
	 * @param avgTime
	 *            the new avg time
	 */
	public void setAvgTime(double avgTime) {
		this.avgTime = avgTime;
	}

}
