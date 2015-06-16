package com.einar.supervision.service;

import com.einar.supervision.bean.HitsHistorisation;
import com.einar.supervision.bean.HitsStat;

public interface HitService {

	/**
	 * Recuperation des statistiques sur les request hits
	 * 
	 * @return
	 */
	HitsStat getStatistics(long startDate, long endDate);

	/**
	 * Recuperation de l'historique des request hits
	 * 
	 * @return
	 */
	HitsHistorisation getHistorisation(long startDate, long endDate);

	/**
	 * Ajout d'une request hit dans le système
	 * 
	 * @param id
	 */
	void addHit(long creationDate, long duration, String path, boolean status);

}
