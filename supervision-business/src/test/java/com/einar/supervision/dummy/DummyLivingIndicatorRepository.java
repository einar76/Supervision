package com.einar.supervision.dummy;

import java.util.ArrayList;
import java.util.List;

import com.einar.supervision.bean.LivingIndicator;
import com.einar.supervision.bean.LivingResourcePk;
import com.einar.supervision.dao.LivingIndicatorRepository;

public class DummyLivingIndicatorRepository implements LivingIndicatorRepository {

	private List<LivingIndicator> datum = new ArrayList<LivingIndicator>();

	public long count() {
		return datum.size();
	}

	public void delete(LivingResourcePk arg0) {
		// TODO Auto-generated method stub

	}

	public void delete(LivingIndicator arg0) {
		// TODO Auto-generated method stub

	}

	public void delete(Iterable<? extends LivingIndicator> arg0) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		datum = new ArrayList<LivingIndicator>();
	}

	public boolean exists(LivingResourcePk arg0) {
		return findOne(arg0) != null;
	}

	public Iterable<LivingIndicator> findAll() {
		return datum;
	}

	public Iterable<LivingIndicator> findAll(Iterable<LivingResourcePk> arg0) {
		// TODO Auto-generated method stub
		return null;

	}

	public LivingIndicator findOne(LivingResourcePk arg0) {

		for (LivingIndicator data : datum) {
			if (data.getKey().getId() == arg0.getId() && data.getKey().getDate() == arg0.getDate()) {
				return data;
			}
		}

		return null;
	}

	public <S extends LivingIndicator> S save(S arg0) {
		datum.add(arg0);
		return null;
	}

	public <S extends LivingIndicator> Iterable<S> save(Iterable<S> arg0) {
		for (LivingIndicator lr : arg0) {
			save(lr);
		}
		return null;
	}

	public List<LivingIndicator> findAllById(Long id) {
		List<LivingIndicator> retour = new ArrayList<LivingIndicator>();

		for (LivingIndicator data : datum) {
			if (data.getKey().getId() == id) {
				retour.add(data);
			}
		}

		return retour;
	}

	public LivingIndicator findLastEntry(Long id) {

		List<LivingIndicator> retour = findAllById(id);
		if (retour.size() > 0) {
			return retour.get(retour.size() - 1);
		}

		return null;
	}

	public List<LivingIndicator> findAllById(Long id, Long start, Long end) {
		List<LivingIndicator> retour = new ArrayList<LivingIndicator>();

		for (LivingIndicator data : datum) {
			if (data.getKey().getId() == id && data.getKey().getDate()>=start && data.getKey().getDate()<end) {
				retour.add(data);
			}
		}

		return retour;
	}

}
