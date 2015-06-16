package com.einar.supervision.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.einar.supervision.bean.ResourceDetails;
import com.einar.supervision.bean.ResourceInformations;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/supervision-business-context-test.xml" })
public class ResourceServiceTest {

	@Autowired
	private ResourceService resourceServiceImpl;
	
	@Test
	public void test() {
		
		resourceServiceImpl.record(1L, 300, true, "without comment", "name");
		resourceServiceImpl.record(2L, 850, true, "without comment", "name");
		resourceServiceImpl.record(1L, 20, false, "with comment", "name");
		
		ResourceInformations info1 = resourceServiceImpl.getInformations(1L);
		Assert.assertNotNull(info1);
		ResourceInformations info2 = resourceServiceImpl.getInformations(2L);
		Assert.assertNotNull(info2);
		ResourceInformations info3 = resourceServiceImpl.getInformations(3L);
		Assert.assertNull(info3);
		
		Assert.assertEquals(info1.getId(), 1L);
		Assert.assertEquals(info1.getLastComment(), "with comment");
		Assert.assertEquals(info1.getLastDuration(), 20);
		Assert.assertEquals(info1.isLastState(), false);
		
		Assert.assertEquals(info2.getId(), 2L);
		Assert.assertEquals(info2.getLastComment(), "without comment");
		Assert.assertEquals(info2.getLastDuration(), 850);
		Assert.assertEquals(info2.isLastState(), true);
		
		Assert.assertEquals(info1.getExecution().getNbCall(), 2);
		Assert.assertEquals(info1.getExecution().getTotalTime(), 320);
		Assert.assertEquals(info1.getExecution().getAvgTime(), 160,0);
		Assert.assertEquals(info1.getExecution().getMinTime(), 20);
		Assert.assertEquals(info1.getExecution().getMaxTime(), 300);
		
		Assert.assertEquals(info2.getExecution().getNbCall(), 1);
		Assert.assertEquals(info2.getExecution().getTotalTime(), 850);
		Assert.assertEquals(info2.getExecution().getAvgTime(), 850,0);
		Assert.assertEquals(info2.getExecution().getMinTime(), 850);
		Assert.assertEquals(info2.getExecution().getMaxTime(), 850);
		
		ResourceDetails detail1 = resourceServiceImpl.getDetail(1L);
		Assert.assertNotNull(detail1);
		ResourceDetails detail2 = resourceServiceImpl.getDetail(2L);
		Assert.assertNotNull(detail2);
		ResourceDetails detail3 = resourceServiceImpl.getDetail(3L);
		Assert.assertNull(detail3);
		
		Assert.assertEquals(detail1.getExecutions().size(),2);
		Assert.assertEquals(detail2.getExecutions().size(),1);

		Assert.assertEquals(detail1.getExecutions().get(0).getTime(),300);
		Assert.assertEquals(detail1.getExecutions().get(0).isState(),true);
		Assert.assertEquals(detail1.getExecutions().get(0).getComment(),"without comment");
		Assert.assertEquals(detail1.getExecutions().get(1).getTime(),20);
		Assert.assertEquals(detail1.getExecutions().get(1).isState(),false);
		Assert.assertEquals(detail1.getExecutions().get(1).getComment(),"with comment");
		
		Assert.assertEquals(detail2.getExecutions().get(0).getTime(),850);
		Assert.assertEquals(detail2.getExecutions().get(0).isState(),true);
		Assert.assertEquals(detail2.getExecutions().get(0).getComment(),"without comment");
		
	}
	
}
