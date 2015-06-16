package com.einar.supervision.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.einar.supervision.bean.IndicatorDetails;
import com.einar.supervision.bean.IndicatorInformation;
import com.einar.supervision.utils.TimeManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/supervision-business-context-test.xml" })
public class IndicatorServiceTest {

	@Autowired
	private IndicatorService indicatorServiceImpl;
	
	@Test
	public void test() {
		
		indicatorServiceImpl.record(1L, 123);
		indicatorServiceImpl.record(1L, 456);
		indicatorServiceImpl.record(1L, 789);
		indicatorServiceImpl.record(2L, 123);
		
		IndicatorInformation ii1 = indicatorServiceImpl.getInformation(1L);
		Assert.assertNotNull(ii1);
		IndicatorInformation ii2 = indicatorServiceImpl.getInformation(2L);
		Assert.assertNotNull(ii2);
		IndicatorInformation ii3 = indicatorServiceImpl.getInformation(3L);
		Assert.assertNull(ii3);
		
		Assert.assertEquals(1L, ii1.getId());
		Assert.assertEquals(789L, ii1.getValue());
		Assert.assertEquals(2L, ii2.getId());
		Assert.assertEquals(123L, ii2.getValue());
		
		IndicatorDetails id1 = indicatorServiceImpl.getDetail(1L, TimeManager.getTodayInMillis(), TimeManager.getTomorrowInMillis());
		Assert.assertNotNull(id1);
		Assert.assertEquals(id1.getInformations().size(), 3);
		IndicatorDetails id2 = indicatorServiceImpl.getDetail(2L, TimeManager.getTodayInMillis(), TimeManager.getTomorrowInMillis());
		Assert.assertNotNull(id2);
		Assert.assertEquals(id2.getInformations().size(), 1);
		IndicatorDetails id3 = indicatorServiceImpl.getDetail(3L, TimeManager.getTodayInMillis(), TimeManager.getTomorrowInMillis());
		Assert.assertNotNull(id3);
		Assert.assertEquals(id3.getInformations().size(), 0);
		
		Assert.assertEquals(id1.getInformations().get(0).getId(), 1L);
		Assert.assertEquals(id1.getInformations().get(0).getValue(), 123);
		Assert.assertEquals(id1.getInformations().get(1).getId(), 1L);
		Assert.assertEquals(id1.getInformations().get(1).getValue(), 456);
		Assert.assertEquals(id1.getInformations().get(2).getId(), 1L);
		Assert.assertEquals(id1.getInformations().get(2).getValue(), 789);

		Assert.assertEquals(id2.getInformations().get(0).getId(), ii2.getId());
		Assert.assertEquals(id2.getInformations().get(0).getValue(), ii2.getValue());
		
	}
	
}
