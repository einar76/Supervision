package com.einar.supervision.service;

import com.einar.supervision.bean.IndicatorDetails;
import com.einar.supervision.bean.IndicatorInformation;

/**
 * Gestion des indicateurs � superviser
 * @author P093109
 *
 */
public interface IndicatorService {

	/**
	 * Enregistrement d'un indicateur
	 * @param id
	 * @param value
	 */
	void record(long id, int value);
	
	/**
	 * Recuperation des informations d'un indicateur
	 * @param id
	 * @return
	 */
	IndicatorInformation getInformation(long id);
	
	/**
	 * Recuperation des d�tails d'un indicateur
	 * @param id
	 * @return
	 */
	IndicatorDetails getDetail(long id, long startDate, long endDate);
	
}
