package com.einar.supervision.bean;

public class HitsStat {

	private long nbTotal;
	private long nbOk;
	private float errorRatio;
	private long minDuration;
	private long maxDuration;
	private long avgDuration;

	public long getNbTotal() {
		return nbTotal;
	}

	public void setNbTotal(long nbTotal) {
		this.nbTotal = nbTotal;
	}

	public long getNbOk() {
		return nbOk;
	}

	public void setNbOk(long nbOk) {
		this.nbOk = nbOk;
	}

	public float getErrorRatio() {
		return errorRatio;
	}

	public void setErrorRatio(float errorRatio) {
		this.errorRatio = errorRatio;
	}

	public long getMinDuration() {
		return minDuration;
	}

	public void setMinDuration(long minDuration) {
		this.minDuration = minDuration;
	}

	public long getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(long maxDuration) {
		this.maxDuration = maxDuration;
	}

	public long getAvgDuration() {
		return avgDuration;
	}

	public void setAvgDuration(long avgDuration) {
		this.avgDuration = avgDuration;
	}

}
