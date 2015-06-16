package com.einar.supervision.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.einar.supervision.bean.LivingResource;
import com.einar.supervision.bean.LivingResourcePk;

/**
 * Gestion des status des ressources à superviser
 * @author P093109
 *
 */
public interface LivingResourceRepository extends CrudRepository<LivingResource, LivingResourcePk> {

	/**
	 * Recuperation des statistics depuis son identifiant
	 * @param id
	 * @return
	 */
	@Query("select COUNT(c), SUM(execution), MIN(execution), MAX(execution), AVG(execution) from LivingResource c where key.id=?1 and key.date>=?2 and key.date<?3 group by key.id")
	List<Object[]> findAllStatistics(Long id, Long start, Long end);

	/**
	 * Recuperation de toutes les lignes depuis un id
	 * @param id
	 * @return
	 */
	@Query("select c from LivingResource c where key.id=?1 and key.date>=?2 and key.date<?3")
	List<LivingResource> findAllById(Long id, Long start, Long end);
}
