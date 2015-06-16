package com.einar.supervision.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.einar.supervision.bean.IndicatorDetails;
import com.einar.supervision.bean.IndicatorInformation;
import com.einar.supervision.indicator.Indicator;
import com.einar.supervision.service.IndicatorService;
import com.einar.supervision.utils.TimeManager;

@Controller
@RequestMapping(value = "/indicator")
public class IndicatorController {

	@Autowired
	List<Indicator> indicatorsToTest;

	@Autowired
	IndicatorService indicatorServiceImpl;

	@RequestMapping("/information")
	public @ResponseBody
	IndicatorInformation getServiceInformation(@RequestParam(value = "id", required = true) Long id) {

		if (indicatorsToTest != null) {
			for (Indicator indicator : indicatorsToTest) {
				if (indicator.getId() == id) {
					if (indicator.isDynamic()) {
						IndicatorInformation ii = indicatorServiceImpl.getInformation(indicator.getId());
						ii.setName(indicator.getName());
						return ii;
					} else {
						IndicatorInformation ii = new IndicatorInformation();
						ii.setId(indicator.getId());
						ii.setName(indicator.getName());
						ii.setValue(indicator.getValue());
						return ii;
					}
				}
			}
		}

		return null;
	}

	@RequestMapping("/informations")
	public @ResponseBody
	List<IndicatorInformation> getServiceInformations() {

		List<IndicatorInformation> list = new ArrayList<IndicatorInformation>();
		if (indicatorsToTest != null) {
			for (Indicator indicator : indicatorsToTest) {
				if (indicator.isDynamic()) {
					IndicatorInformation ii = indicatorServiceImpl.getInformation(indicator.getId());
					ii.setName(indicator.getName());
					list.add(ii);
				} else {
					IndicatorInformation ii = new IndicatorInformation();
					ii.setId(indicator.getId());
					ii.setName(indicator.getName());
					ii.setValue(indicator.getValue());
					list.add(ii);
				}
			}
		}

		return list;
	}

	@RequestMapping("/detail")
	public @ResponseBody
	IndicatorDetails getServiceDetail(@RequestParam(value = "id", required = true) Long id, @RequestParam(value = "start", required = false) Long startDate, @RequestParam(value = "end", required = false) Long endDate) {
		
		long start = 0;
		long end = 0;
		
		if (startDate==null) {
			start=TimeManager.getTodayInMillis();
			end=TimeManager.getTomorrowInMillis();
		}
		else if (endDate==null) {
			start=TimeManager.getDateInMillis(startDate);
			end=TimeManager.getNextDateInMillis(startDate);
		}
		else {
			start=TimeManager.getDateInMillis(startDate);
			end=TimeManager.getDateInMillis(endDate);
		}
		
		IndicatorDetails detail = indicatorServiceImpl.getDetail(id, start, end);
		
		if (indicatorsToTest != null && detail!=null) {
			for (Indicator indicator : indicatorsToTest) {
				if (indicator.getId()==id.longValue()) {
					detail.setName(indicator.getName());
					return detail;
				}
			}
		}
		
		return detail;
	}

	@RequestMapping("/ping")
	public @ResponseBody
	Boolean ping() {
		return true;
	}

}
