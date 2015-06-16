package com.einar.supervision.bean;

/**
 * The Class ResourceInformations.
 */
public class ResourceInformations {

	/** The id. */
	private long id;

	/** The name. */
	private String name;

	/** The last state. */
	private boolean lastState;

	/** The last comment. */
	private String lastComment;

	/** The last duration. */
	private long lastDuration;

	/** The execution. */
	private ExecutionStats execution;

	/**
	 * Gets the last duration.
	 * 
	 * @return the last duration
	 */
	public long getLastDuration() {
		return lastDuration;
	}

	/**
	 * Sets the last duration.
	 * 
	 * @param lastDuration
	 *            the new last duration
	 */
	public void setLastDuration(long lastDuration) {
		this.lastDuration = lastDuration;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Checks if is last state.
	 * 
	 * @return true, if is last state
	 */
	public boolean isLastState() {
		return lastState;
	}

	/**
	 * Sets the last state.
	 * 
	 * @param lastState
	 *            the new last state
	 */
	public void setLastState(boolean lastState) {
		this.lastState = lastState;
	}

	/**
	 * Gets the last comment.
	 * 
	 * @return the last comment
	 */
	public String getLastComment() {
		return lastComment;
	}

	/**
	 * Sets the last comment.
	 * 
	 * @param lastComment
	 *            the new last comment
	 */
	public void setLastComment(String lastComment) {
		this.lastComment = lastComment;
	}

	/**
	 * Gets the execution.
	 * 
	 * @return the execution
	 */
	public ExecutionStats getExecution() {
		return execution;
	}

	/**
	 * Sets the execution.
	 * 
	 * @param execution
	 *            the new execution
	 */
	public void setExecution(ExecutionStats execution) {
		this.execution = execution;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("ResourceInformations[id=%d, etat='%b', duration=%d {Nb:%d Total:%d Min:%d Max:%d Avg:%d}]", getId(), isLastState(), lastDuration, (int) execution.getNbCall(),
				(int) execution.getTotalTime(), (int) execution.getMinTime(), (int) execution.getMaxTime(), (int) execution.getAvgTime());
	}

}
