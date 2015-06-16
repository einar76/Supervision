package com.einar.supervision.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class ResourceStatistics.
 */
public class ResourceDetails {

	private String name;

	/** The executions. */
	private List<ExecutionInformation> executions = new ArrayList<ExecutionInformation>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the executions.
	 * 
	 * @return the executions
	 */
	public List<ExecutionInformation> getExecutions() {
		return executions;
	}

	/**
	 * Sets the executions.
	 * 
	 * @param executions
	 *            the new executions
	 */
	public void setExecutions(List<ExecutionInformation> executions) {
		this.executions = executions;
	}

	/**
	 * Adds the execution.
	 * 
	 * @param execution
	 *            the execution
	 */
	public void addExecution(ExecutionInformation execution) {
		this.executions.add(execution);
	}

}
