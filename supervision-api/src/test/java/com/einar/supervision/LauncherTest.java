package com.einar.supervision;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.einar.supervision.bean.ResourceDetails;
import com.einar.supervision.bean.ResourceInformations;
import com.einar.supervision.service.ResourceService;
import com.einar.supervision.service.TestableService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/supervision-api-context-test.xml" })
public class LauncherTest {

	@Autowired
	List<TestableService> servicesToTest;
	
	@Autowired
	private TestableServiceLauncher testableServiceLauncher;

	@Autowired
	ResourceService resourceService;
	
	@Test
	public void test() {

		testableServiceLauncher.start();

		for (TestableService s : servicesToTest) {
			ResourceInformations info = resourceService.getInformations(s.getId());
			Assert.assertNotNull(info);
			ResourceDetails detail = resourceService.getDetail(s.getId());
			Assert.assertNotNull(detail);
			Assert.assertEquals(testableServiceLauncher.getIteration(), detail.getExecutions().size());
		}
		
		
	}

}
