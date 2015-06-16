package com.einar.supervision.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.einar.supervision.bean.IndicatorDetails;
import com.einar.supervision.bean.IndicatorInformation;
import com.einar.supervision.bean.LivingIndicator;
import com.einar.supervision.bean.LivingResourcePk;
import com.einar.supervision.dao.LivingIndicatorRepository;
import com.einar.supervision.service.IndicatorService;

/**
 * {@inheritDoc}
 */
public class IndicatorServiceImpl implements IndicatorService {

	@Autowired
	private LivingIndicatorRepository livingIndicatorRepository;

	/**
	 * {@inheritDoc}
	 */
	public void record(long id, int value) {
		LivingResourcePk pk = new LivingResourcePk(id);
		LivingIndicator li = new LivingIndicator();
		li.setKey(pk);
		li.setValue(value);
		li.setDynamic(true);
		
		livingIndicatorRepository.save(li);
		
	}

	/**
	 * {@inheritDoc}
	 */
	public IndicatorInformation getInformation(long id) {
		LivingIndicator li = livingIndicatorRepository.findLastEntry(id);
		
		if (li==null) {
			return null;
		}
		
		IndicatorInformation ii = new IndicatorInformation();
		ii.setId(li.getKey().getId());
		ii.setDate(li.getKey().getDate());
		ii.setValue(""+li.getValue());
		ii.setDynamic(li.isDynamic());
		
		return ii;
	}

	/**
	 * {@inheritDoc}
	 */
	public IndicatorDetails getDetail(long id, long startDate, long endDate) {

		IndicatorDetails details = new IndicatorDetails();
		
		for (LivingIndicator li : livingIndicatorRepository.findAllById(id, startDate, endDate)) {
			IndicatorInformation ii = new IndicatorInformation();
			ii.setId(li.getKey().getId());
			ii.setDate(li.getKey().getDate());
			ii.setValue(""+li.getValue());
			ii.setDynamic(li.isDynamic());
			details.addInformation(ii);
		}
		
		return details;
	}

}
