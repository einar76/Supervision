package com.einar.supervision.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.einar.supervision.bean.ExecutionInformation;
import com.einar.supervision.bean.ExecutionStats;
import com.einar.supervision.bean.LivingResource;
import com.einar.supervision.bean.LivingResourcePk;
import com.einar.supervision.bean.ResourceDetails;
import com.einar.supervision.bean.ResourceInformations;
import com.einar.supervision.dao.LivingResourceRepository;
import com.einar.supervision.service.ResourceService;

/**
 * {@inheritDoc}
 */
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	LivingResourceRepository livingResourceRepository;

	/**
	 * {@inheritDoc}
	 */
	public void record(long id, long time, boolean status, String comment, String name) {

		LivingResourcePk pk = new LivingResourcePk(id);
		LivingResource resource = new LivingResource();
		resource.setKey(pk);
		resource.setEtat(status);
		resource.setExecution(time);
		resource.setCommentaire(comment);
		resource.setName(name);

		System.out.println(resource);

		livingResourceRepository.save(resource);

	}

	/**
	 * {@inheritDoc}
	 */
	public ResourceInformations getInformations(long id, long startDate, long endDate) {

		List<LivingResource> resources = livingResourceRepository.findAllById(id, startDate, endDate);

		if (resources.size()==0) {
			return null;
		}
		
		LivingResource lastOne = resources.get(resources.size() - 1);

		ResourceInformations info = new ResourceInformations();
		info.setId(id);
		info.setLastComment(lastOne.getCommentaire());
		info.setName(lastOne.getName());
		info.setLastState(lastOne.isEtat());
		info.setLastDuration(lastOne.getExecution());

		List<Object[]> objects = livingResourceRepository.findAllStatistics(id, startDate, endDate);
		Object[] line = objects.get(0);

		ExecutionStats stats = new ExecutionStats();
		stats.setNbCall((Long)line[0]);
		stats.setTotalTime((Long) line[1]);
		stats.setMinTime((Long) line[2]);
		stats.setMaxTime((Long) line[3]);
		stats.setAvgTime(((Double) line[4]).intValue());

		info.setExecution(stats);

		return info;

	}

	/**
	 * {@inheritDoc}
	 */
	public ResourceDetails getDetail(long id, long startDate, long endDate) {

		List<LivingResource> resources = livingResourceRepository.findAllById(id, startDate, endDate);

		if (resources.size()==0) {
			return null;
		}
		
		ResourceDetails rs = new ResourceDetails();
		
		rs.setName(resources.get(0).getName());
		
		for (LivingResource resource : resources) {

			ExecutionInformation exec = new ExecutionInformation();
			exec.setComment(resource.getCommentaire());
			exec.setState(resource.isEtat());
			exec.setTime(resource.getExecution());
			exec.setDate(resource.getKey().getDate());

			rs.addExecution(exec);
		}

		return rs;
	}

}
