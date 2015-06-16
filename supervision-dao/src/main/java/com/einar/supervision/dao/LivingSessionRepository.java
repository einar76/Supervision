package com.einar.supervision.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.einar.supervision.bean.LivingSession;

/**
 * Gestion de la vie des sessions
 * 
 * @author P093109
 * 
 */
public interface LivingSessionRepository extends CrudRepository<LivingSession, String> {

	@Query("select c from LivingSession c where createTime>=?1 and createTime<?2")
	List<LivingSession> findAllByDate(Long start, Long end);

}
