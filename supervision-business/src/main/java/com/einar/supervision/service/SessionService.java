package com.einar.supervision.service;

import com.einar.supervision.bean.SessionsHistorisation;
import com.einar.supervision.bean.SessionsStat;

/**
 * Gestion des sessions à superviser
 * @author P093109
 *
 */
public interface SessionService {

	/**
	 * Recuperation des statistiques sur les sessions
	 * @return
	 */
	SessionsStat getStatistics(long startDate, long endDate);
	
	/**
	 * Recuperation de l'historique des sessions
	 * @return
	 */
	SessionsHistorisation getHistorisation(long startDate, long endDate);
	
	/**
	 * Ajout d'une session dans le système
	 * @param id
	 */
	void addSession(String id);
	
	/**
	 * Fermeture d'une session dans le système
	 * @param id
	 */
	void closeSession(String id);
	
}
