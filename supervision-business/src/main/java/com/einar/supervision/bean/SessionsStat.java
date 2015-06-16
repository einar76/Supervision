package com.einar.supervision.bean;

/**
 * The Class SessionsStat.
 */
public class SessionsStat {

	/** The nb total. */
	private long nbTotal;

	/** The nb opened. */
	private long nbOpened;

	/** The avg duration. */
	private float avgDuration;

	/** The max duration. */
	private long maxDuration;

	/** The min duration. */
	private long minDuration;

	/**
	 * Gets the max duration.
	 * 
	 * @return the max duration
	 */
	public long getMaxDuration() {
		return maxDuration;
	}

	/**
	 * Sets the max duration.
	 * 
	 * @param maxDuration
	 *            the new max duration
	 */
	public void setMaxDuration(long maxDuration) {
		this.maxDuration = maxDuration;
	}

	/**
	 * Gets the min duration.
	 * 
	 * @return the min duration
	 */
	public long getMinDuration() {
		return minDuration;
	}

	/**
	 * Sets the min duration.
	 * 
	 * @param minDuration
	 *            the new min duration
	 */
	public void setMinDuration(long minDuration) {
		this.minDuration = minDuration;
	}

	/**
	 * Gets the nb total.
	 * 
	 * @return the nb total
	 */
	public long getNbTotal() {
		return nbTotal;
	}

	/**
	 * Sets the nb total.
	 * 
	 * @param nbTotal
	 *            the new nb total
	 */
	public void setNbTotal(long nbTotal) {
		this.nbTotal = nbTotal;
	}

	/**
	 * Gets the nb opened.
	 * 
	 * @return the nb opened
	 */
	public long getNbOpened() {
		return nbOpened;
	}

	/**
	 * Sets the nb opened.
	 * 
	 * @param nbOpened
	 *            the new nb opened
	 */
	public void setNbOpened(long nbOpened) {
		this.nbOpened = nbOpened;
	}

	/**
	 * Gets the avg duration.
	 * 
	 * @return the avg duration
	 */
	public float getAvgDuration() {
		return avgDuration;
	}

	/**
	 * Sets the avg duration.
	 * 
	 * @param avgDuration
	 *            the new avg duration
	 */
	public void setAvgDuration(float avgDuration) {
		this.avgDuration = avgDuration;
	}

}
