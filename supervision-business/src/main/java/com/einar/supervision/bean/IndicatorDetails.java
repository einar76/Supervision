package com.einar.supervision.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class IndicatorDetails.
 */
public class IndicatorDetails {

	private String name;

	/** The informations. */
	private List<IndicatorInformation> informations = new ArrayList<IndicatorInformation>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the informations.
	 * 
	 * @return the informations
	 */
	public List<IndicatorInformation> getInformations() {
		return informations;
	}

	/**
	 * Sets the informations.
	 * 
	 * @param informations
	 *            the new informations
	 */
	public void setInformations(List<IndicatorInformation> informations) {
		this.informations = informations;
	}

	/**
	 * Adds the information.
	 * 
	 * @param information
	 *            the information
	 */
	public void addInformation(IndicatorInformation information) {
		this.informations.add(information);
	}

}
