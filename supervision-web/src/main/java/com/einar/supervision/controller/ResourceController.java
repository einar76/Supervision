package com.einar.supervision.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.einar.supervision.bean.ResourceDetails;
import com.einar.supervision.bean.ResourceInformations;
import com.einar.supervision.service.ResourceService;
import com.einar.supervision.service.TestableService;
import com.einar.supervision.utils.TimeManager;

@Controller
@RequestMapping(value = "/resource")
public class ResourceController {

	@Autowired
	List<TestableService> servicesToTest;

	@Autowired
	ResourceService resourceServiceImpl;

	@RequestMapping("/information")
	public @ResponseBody
	ResourceInformations getServiceInformation(@RequestParam(value = "id", required = true) Long id, @RequestParam(value = "start", required = false) Long startDate,
			@RequestParam(value = "end", required = false) Long endDate) {

		long start = 0;
		long end = 0;

		if (startDate == null) {
			start = TimeManager.getTodayInMillis();
			end = TimeManager.getTomorrowInMillis();
		} else if (endDate == null) {
			start = TimeManager.getDateInMillis(startDate);
			end = TimeManager.getNextDateInMillis(startDate);
		} else {
			start = TimeManager.getDateInMillis(startDate);
			end = TimeManager.getDateInMillis(endDate);
		}

		return resourceServiceImpl.getInformations(id, start, end);
	}

	@RequestMapping("/detail")
	public @ResponseBody
	ResourceDetails getServiceDetail(@RequestParam(value = "id", required = true) Long id, @RequestParam(value = "start", required = false) Long startDate,
			@RequestParam(value = "end", required = false) Long endDate) {

		long start = 0;
		long end = 0;

		if (startDate == null) {
			start = TimeManager.getTodayInMillis();
			end = TimeManager.getTomorrowInMillis();
		} else if (endDate == null) {
			start = TimeManager.getDateInMillis(startDate);
			end = TimeManager.getNextDateInMillis(startDate);
		} else {
			start = TimeManager.getDateInMillis(startDate);
			end = TimeManager.getDateInMillis(endDate);
		}

		return resourceServiceImpl.getDetail(id, start, end);
	}

	@RequestMapping("/informations")
	public @ResponseBody
	List<ResourceInformations> getServiceInformations(@RequestParam(value = "start", required = false) Long startDate, @RequestParam(value = "end", required = false) Long endDate) {

		long start = 0;
		long end = 0;

		if (startDate == null) {
			start = TimeManager.getTodayInMillis();
			end = TimeManager.getTomorrowInMillis();
		} else if (endDate == null) {
			start = TimeManager.getDateInMillis(startDate);
			end = TimeManager.getNextDateInMillis(startDate);
		} else {
			start = TimeManager.getDateInMillis(startDate);
			end = TimeManager.getDateInMillis(endDate);
		}

		List<ResourceInformations> list = new ArrayList<ResourceInformations>();
		if (servicesToTest != null) {
			for (TestableService service : servicesToTest) {
				list.add(resourceServiceImpl.getInformations(service.getId(), start, end));
			}
		}

		return list;
	}

	@RequestMapping("/ping")
	public @ResponseBody
	Boolean ping() {
		return true;
	}

}
