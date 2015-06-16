package com.einar.supervision.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.einar.supervision.bean.LivingHit;

public interface LivingHitRepository extends CrudRepository<LivingHit, Long> {

	@Query("select c from LivingHit c where creationDate>=?1 and creationDate<?2")
	List<LivingHit> findAllByDate(Long start, Long end);

}
