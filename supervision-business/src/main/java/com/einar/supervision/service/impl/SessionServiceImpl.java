package com.einar.supervision.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.einar.supervision.bean.LivingSession;
import com.einar.supervision.bean.SessionsHistorisation;
import com.einar.supervision.bean.SessionsStat;
import com.einar.supervision.dao.LivingSessionRepository;
import com.einar.supervision.service.SessionService;

/**
 * {@inheritDoc}
 */
public class SessionServiceImpl implements SessionService {

	@Autowired
	private LivingSessionRepository livingSessionRepository;

	/**
	 * {@inheritDoc}
	 */
	public SessionsStat getStatistics(long startDate, long endDate) {

		SessionsStat stat = new SessionsStat();

		long nbFinished = 0;
		long nbTotal = 0;

		long totalTime = 0;

		long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;

		for (LivingSession s : livingSessionRepository.findAllByDate(startDate, endDate)) {
			nbTotal++;
			if (s.getFinishedTime() > 0) {
				nbFinished++;

				long time = s.getFinishedTime() - s.getCreateTime();

				totalTime += time;

				if (max < time) {
					max = time;
				}
				if (min > time) {
					min = time;
				}
			}
		}

		stat.setNbTotal(nbTotal);
		stat.setNbOpened(nbTotal - nbFinished);
		if (nbFinished > 0) {
			stat.setAvgDuration(totalTime / nbFinished);
			stat.setMinDuration(min);
			stat.setMaxDuration(max);
		} else {
			stat.setAvgDuration(0);
			stat.setMinDuration(0);
			stat.setMaxDuration(0);
		}

		return stat;
	}

	/**
	 * {@inheritDoc}
	 */
	public SessionsHistorisation getHistorisation(long startDate, long endDate) {

		SessionsHistorisation histo = new SessionsHistorisation();

		long startMax = Long.MIN_VALUE;
		long startMin = Long.MAX_VALUE;

		histo.setInterval(1000 * 60);
		histo.setMax(Long.MIN_VALUE);

		Iterable<LivingSession> sessions = livingSessionRepository.findAllByDate(startDate, endDate);

		for (LivingSession ses : sessions) {

			long startInterval = (long) (ses.getCreateTime() / histo.getInterval());
			long endInterval = (long) (ses.getFinishedTime() / histo.getInterval());

			if (startMax < startInterval) {
				startMax = startInterval;
			}
			if (startMin > startInterval) {
				startMin = startInterval;
			}
			if (startMax < endInterval) {
				startMax = endInterval;
			}
			if (startMin > endInterval) {
				startMin = endInterval;
			}
		}

		for (long i = startMin; i <= startMax; i++) {
			histo.init(i);
		}

		for (LivingSession s : sessions) {

			long startInterval = (long) (s.getCreateTime() / histo.getInterval());
			histo.addCreation(startInterval);

			if (s.getFinishedTime() != 0) {
				long endInterval = (long) (s.getFinishedTime() / histo.getInterval());
				histo.addDestruction(endInterval);
			}

		}

		long total = 0;

		for (Integer value : histo.getCreations().values()) {
			if (value > histo.getMax()) {
				histo.setMax(value);
				total += value;
			}
		}

		histo.setAvg(0);
		if (histo.getCreations().values().size() > 0) {
			histo.setAvg(total / histo.getCreations().values().size());
		}

		return histo;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addSession(String id) {

		LivingSession session = new LivingSession();
		session.setId(id);
		session.setCreateTime(System.currentTimeMillis());
		session.setFinishedTime(0);

		livingSessionRepository.save(session);

	}

	/**
	 * {@inheritDoc}
	 */
	public void closeSession(String id) {
		LivingSession session = livingSessionRepository.findOne(id);
		session.setFinishedTime(System.currentTimeMillis());
		livingSessionRepository.save(session);
	}

}
