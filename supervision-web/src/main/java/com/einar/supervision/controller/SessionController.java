package com.einar.supervision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.einar.supervision.bean.SessionsHistorisation;
import com.einar.supervision.bean.SessionsStat;
import com.einar.supervision.service.SessionService;
import com.einar.supervision.utils.TimeManager;

@Controller
@RequestMapping(value = "/session")
public class SessionController {

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/stat")
	public @ResponseBody
	SessionsStat getSessionsStat(@RequestParam(value = "start", required = false) Long startDate, @RequestParam(value = "end", required = false) Long endDate) {
		
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
		
		return sessionService.getStatistics(start,end);
	}

	@RequestMapping("/historisation")
	public @ResponseBody
	SessionsHistorisation getSessionsHistorisation(@RequestParam(value = "start", required = false) Long startDate, @RequestParam(value = "end", required = false) Long endDate) {
		
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
		
		return sessionService.getHistorisation(start,end);
	}

}
