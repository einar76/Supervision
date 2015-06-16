package com.einar.supervision.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.einar.supervision.bean.LivingResource;
import com.einar.supervision.bean.LivingResourcePk;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/supervision-dao-context-test.xml" })
public class LivingResourceTest {

	@Autowired
	LivingResourceRepository livingServiceRepository;

	@Test
	public void test() {

		long id = 1000;

		LivingResource ls1 = new LivingResource();
		ls1.setKey(new LivingResourcePk(id));
		ls1.setExecution(20000);
		ls1.setEtat(true);

		livingServiceRepository.save(ls1);

		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);

		LivingResource ls2 = new LivingResource();
		ls2.setKey(new LivingResourcePk(id));
		ls2.getKey().setDate(yesterday.getTimeInMillis());
		ls2.setExecution(20000);
		ls2.setEtat(true);

		livingServiceRepository.save(ls2);

		Calendar lastYear = Calendar.getInstance();
		lastYear.add(Calendar.YEAR, -1);

		LivingResource ls3 = new LivingResource();
		ls3.setKey(new LivingResourcePk(id));
		ls3.getKey().setDate(lastYear.getTimeInMillis());
		ls3.setExecution(50000);
		ls3.setEtat(true);

		livingServiceRepository.save(ls3);

		for (LivingResource ls : livingServiceRepository.findAll()) {
			System.out.println(ls);
		}

		long nb = 3;
		long total = ls1.getExecution() + ls2.getExecution() + ls3.getExecution();
		double avg = total / nb;
		long min = ls1.getExecution();
		long max = ls3.getExecution();

		List<Object[]> datum = livingServiceRepository.findAllStatistics(id);

		Assert.assertNotNull(datum);

		Object[] line = datum.get(0);
		Assert.assertNotNull(line);

		Assert.assertEquals(nb, line[0]);
		Assert.assertEquals(total, line[1]);
		Assert.assertEquals(min, line[2]);
		Assert.assertEquals(max, line[3]);
		Assert.assertTrue(avg == ((Double) line[4]).doubleValue());

	}

}
