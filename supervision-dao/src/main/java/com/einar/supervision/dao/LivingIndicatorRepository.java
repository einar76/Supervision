package com.einar.supervision.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.einar.supervision.bean.LivingIndicator;
import com.einar.supervision.bean.LivingResourcePk;

/**
 * Gestion des indicateurs dynamiques
 * 
 * @author P093109
 * 
 */
public interface LivingIndicatorRepository extends CrudRepository<LivingIndicator, LivingResourcePk> {

	/**
	 * Recuperation de toutes les lignes depuis un id
	 * 
	 * @param id
	 * @return
	 */
	@Query("select c from LivingIndicator c where key.id=?1")
	List<LivingIndicator> findAllById(Long id);

	@Query("select c from LivingIndicator c where key.id=?1 and key.date>=?2 and key.date<?3")
	List<LivingIndicator> findAllById(Long id, Long start, Long end);
	
	/**
	 * Recuperation de la dernière ligne enregistrer
	 * 
	 * @param id
	 * @return
	 */
	@Query("select c from LivingIndicator c where key.id=?1 AND key.date in (select MAX(key.date) from LivingIndicator where key.id=?1)")
	LivingIndicator findLastEntry(Long id);
}
