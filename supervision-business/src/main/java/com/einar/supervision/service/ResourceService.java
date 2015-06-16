package com.einar.supervision.service;

import com.einar.supervision.bean.ResourceDetails;
import com.einar.supervision.bean.ResourceInformations;

/**
 * Gestion des statuts de service à superviser
 * @author P093109
 *
 */
public interface ResourceService {

	/**
	 * Enregistrement d'un nouveau statut de service
	 * 
	 * @param id
	 * @param time
	 * @param status
	 * @param comment
	 * @param name
	 */
	void record(long id, long time, boolean status, String comment, String name);

	/**
	 * Recuperation des informations d'un service
	 * 
	 * @param id
	 * @return
	 */
	ResourceInformations getInformations(long id, long startDate, long endDate);

	/**
	 * Recuperation de tous les statuts d'un service
	 * 
	 * @param id
	 * @return
	 */
	ResourceDetails getDetail(long id, long startDate, long endDate);

}
