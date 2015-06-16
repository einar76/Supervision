package com.einar.supervision.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.einar.supervision.bean.HitsHistorisation;
import com.einar.supervision.bean.HitsStat;
import com.einar.supervision.bean.LivingHit;
import com.einar.supervision.dao.LivingHitRepository;
import com.einar.supervision.service.HitService;

public class HitServiceImpl implements HitService {

	@Autowired
	private LivingHitRepository livingHitRepository;

	public HitsStat getStatistics(long startDate, long endDate) {

		HitsStat stat = new HitsStat();
		long nbFinished = 0;
		long nbTotal = 0;
		long totalTime = 0;

		long maxDuration = Long.MIN_VALUE;
		long minDuration = Long.MAX_VALUE;
		
		for (LivingHit hit : livingHitRepository.findAllByDate(startDate,endDate)) {
			nbTotal++;
			if (hit.isStatus()) {
				nbFinished++;
				totalTime += hit.getDuration();
				
				if (hit.getDuration()>maxDuration) {
					maxDuration=hit.getDuration();
				}

				if (hit.getDuration()<minDuration) {
					minDuration=hit.getDuration();
				}
			}
		}

		stat.setNbTotal(nbTotal);
		stat.setNbOk(nbFinished);
		if (nbFinished > 0) {
			stat.setAvgDuration(totalTime / nbFinished);
		} else {
			stat.setAvgDuration(0);
		}

		if (nbTotal>0) {
			stat.setErrorRatio((nbTotal-nbFinished)/nbTotal);
		}
		else {
			stat.setErrorRatio(0);
		}
		
		if (maxDuration == Long.MIN_VALUE) {
			maxDuration = 0;
		}
		stat.setMaxDuration(maxDuration);

		if (minDuration == Long.MAX_VALUE) {
			minDuration = 0;
		}
		stat.setMinDuration(minDuration);
		
		return stat;
	}

	public HitsHistorisation getHistorisation(long startDate, long endDate) {

		HitsHistorisation histo = new HitsHistorisation();

		long startMax = Long.MIN_VALUE;
		long startMin = Long.MAX_VALUE;
		
		histo.setInterval(1000 * 60);
		histo.setMax(Long.MIN_VALUE);

		Iterable<LivingHit> hits = livingHitRepository.findAllByDate(startDate,endDate);

		for (LivingHit hit : hits) {
			
			long startInterval = (long) (hit.getCreationDate() / histo.getInterval());
			
			if (startMax<startInterval) {
				startMax=startInterval;
			}
			if (startMin>startInterval) {
				startMin=startInterval;
			}
			
		}
		
		for (long i = startMin; i<=startMax; i++) {
			histo.init(i);
		}
		
		for (LivingHit hit : hits) {

			long startInterval = (long) (hit.getCreationDate() / histo.getInterval());

			if (hit.isStatus()) {
				histo.addOk(startInterval);
			} else {
				histo.addKo(startInterval);
			}

			
		}

		long total = 0;

		for (Integer value : histo.getOks().values()) {
			if (value > histo.getMax()) {
				histo.setMax(value);
			}
			total += value;
		}

		histo.setAvg(0);
		if (histo.getOks().values().size() > 0) {
			histo.setAvg(total / histo.getOks().values().size());
		}

		return histo;
	}

	public void addHit(long creationDate, long duration, String path, boolean status) {
		LivingHit hit = new LivingHit();
		
		UUID id = UUID.randomUUID();
		
		hit.setId(id.getMostSignificantBits());
		hit.setCreationDate(creationDate);
		hit.setDuration(duration);
		hit.setPath(path);
		hit.setStatus(status);
		livingHitRepository.save(hit);
	}

}
