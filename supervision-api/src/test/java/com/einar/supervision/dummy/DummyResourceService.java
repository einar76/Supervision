package com.einar.supervision.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.einar.supervision.bean.ExecutionInformation;
import com.einar.supervision.bean.ExecutionStats;
import com.einar.supervision.bean.ResourceDetails;
import com.einar.supervision.bean.ResourceInformations;
import com.einar.supervision.service.ResourceService;

public class DummyResourceService implements ResourceService {

	Map<Long, List<ExecutionInformation>> datum = new HashMap<Long, List<ExecutionInformation>>();

	public void record(long id, long time, boolean status, String comment) {

		ExecutionInformation exec = new ExecutionInformation();
		exec.setComment(comment);
		exec.setDate(System.currentTimeMillis());
		exec.setState(status);
		exec.setTime(time);
		
		if (datum.get(id)==null) {
			datum.put(id, new ArrayList<ExecutionInformation>());
		}
		datum.get(id).add(exec);

	}

	public ResourceInformations getInformations(long id) {
		
		if (datum.get(id)==null) {
			return null;
		}
		
		ResourceInformations info = new ResourceInformations();
		info.setId(id);
		
		ExecutionInformation lastExecution = datum.get(id).get(datum.get(id).size()-1);
		info.setLastComment(lastExecution.getComment());
		info.setLastDuration(lastExecution.getTime());
		info.setLastState(lastExecution.isState());

		info.setExecution(new ExecutionStats());
		
		info.getExecution().setNbCall(datum.get(id).size());
		info.getExecution().setMaxTime(Long.MIN_VALUE);
		info.getExecution().setMinTime(Long.MAX_VALUE);
		
		for (ExecutionInformation exec : datum.get(id)) {
			if (exec.getTime()<info.getExecution().getMinTime()) {
				info.getExecution().setMinTime(exec.getTime());
			}
			if (exec.getTime()>info.getExecution().getMaxTime()) {
				info.getExecution().setMaxTime(exec.getTime());
			}
			info.getExecution().setTotalTime(exec.getTime()+info.getExecution().getTotalTime());
		}
		
		info.getExecution().setAvgTime(info.getExecution().getTotalTime()/info.getExecution().getNbCall());
		
		return info;
	}

	public ResourceDetails getDetail(long id) {

		if (datum.get(id)==null) {
			return null;
		}
		
		ResourceDetails details = new ResourceDetails();

		details.setExecutions(datum.get(id));

		return details;
	}

}
