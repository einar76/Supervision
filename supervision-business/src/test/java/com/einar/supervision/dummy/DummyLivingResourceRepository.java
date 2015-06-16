package com.einar.supervision.dummy;

import java.util.ArrayList;
import java.util.List;

import com.einar.supervision.bean.LivingResource;
import com.einar.supervision.bean.LivingResourcePk;
import com.einar.supervision.dao.LivingResourceRepository;

public class DummyLivingResourceRepository implements LivingResourceRepository {

	private List<LivingResource> datum = new ArrayList<LivingResource>();

	public long count() {
		return datum.size();
	}

	public void delete(LivingResourcePk arg0) {
		// TODO Auto-generated method stub

	}

	public void delete(LivingResource arg0) {
		// TODO Auto-generated method stub

	}

	public void delete(Iterable<? extends LivingResource> arg0) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		datum = new ArrayList<LivingResource>();
	}

	public boolean exists(LivingResourcePk arg0) {
		return findOne(arg0) != null;
	}

	public Iterable<LivingResource> findAll() {
		return datum;
	}

	public Iterable<LivingResource> findAll(Iterable<LivingResourcePk> arg0) {
		// TODO Auto-generated method stub
		return null;

	}

	public LivingResource findOne(LivingResourcePk arg0) {

		for (LivingResource data : datum) {
			if (data.getKey().getId() == arg0.getId() && data.getKey().getDate() == arg0.getDate()) {
				return data;
			}
		}

		return null;
	}

	public <S extends LivingResource> S save(S arg0) {
		datum.add(arg0);
		return null;
	}

	public <S extends LivingResource> Iterable<S> save(Iterable<S> arg0) {
		for (LivingResource lr : arg0) {
			save(lr);
		}
		return null;
	}

	public List<Object[]> findAllStatistics(Long id) {

		List<LivingResource> datum = findAllById(id);
		Object[] retour = new Object[5];
		
		retour[0]=new Long(datum.size());// NB
		retour[1]=new Long(0);// TOTAL
		retour[2]=Long.MAX_VALUE;// MIN
		retour[3]=Long.MIN_VALUE;// MAX
		for (LivingResource data : datum) {
			retour[1]=((Long)retour[1])+data.getExecution();
			
			if (data.getExecution()<((Long)retour[2])) {
				retour[2]=data.getExecution();
			}

			if (data.getExecution()>((Long)retour[3])) {
				retour[3]=data.getExecution();
			}
		}
		retour[4]=new Double(((Long)retour[1]/(Long)retour[0]));// AVG
		
		List<Object[]> ret = new ArrayList<Object[]>();
		ret.add(retour);
		
		return ret;
	}

	public List<LivingResource> findAllById(Long id) {
		List<LivingResource> retour = new ArrayList<LivingResource>();

		for (LivingResource data : datum) {
			if (data.getKey().getId() == id) {
				retour.add(data);
			}
		}

		return retour;
	}

}
