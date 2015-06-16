package com.einar.supervision.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.einar.supervision.bean.LivingIndicator;
import com.einar.supervision.bean.LivingResourcePk;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/supervision-dao-context-test.xml" })
public class LivingIndicatorTest {

	@Autowired
	private LivingIndicatorRepository livingIndicatorRepository;
	
	@Test
	public void test() {

		long id = 1000;

		LivingIndicator li1 = new LivingIndicator();
		li1.setKey(new LivingResourcePk(id));
		li1.setValue(2500);
		livingIndicatorRepository.save(li1);
		System.out.println(li1);

		LivingIndicator li2 = new LivingIndicator();
		li2.setKey(new LivingResourcePk(id));
		li2.setValue(3500);
		livingIndicatorRepository.save(li2);
		System.out.println(li2);

		LivingIndicator li3 = new LivingIndicator();
		li3.setKey(new LivingResourcePk(id+1));
		li3.setValue(4500);
		livingIndicatorRepository.save(li3);
		System.out.println(li3);

		List<LivingIndicator> lis1 = livingIndicatorRepository.findAllById(li1.getKey().getId());
		Assert.assertEquals(lis1.size(), 2);
		Assert.assertEquals(lis1.get(0).getKey().getId(), li1.getKey().getId());
		Assert.assertEquals(lis1.get(0).getKey().getDate(), li1.getKey().getDate());
		Assert.assertEquals(lis1.get(0).getValue(), li1.getValue());
		Assert.assertEquals(lis1.get(1).getKey().getId(), li2.getKey().getId());
		Assert.assertEquals(lis1.get(1).getKey().getDate(), li2.getKey().getDate());
		Assert.assertEquals(lis1.get(1).getValue(), li2.getValue());
		
		List<LivingIndicator> lis3 = livingIndicatorRepository.findAllById(li3.getKey().getId());
		Assert.assertEquals(lis3.size(), 1);
		Assert.assertEquals(lis3.get(0).getKey().getId(), li3.getKey().getId());
		Assert.assertEquals(lis3.get(0).getKey().getDate(), li3.getKey().getDate());
		Assert.assertEquals(lis3.get(0).getValue(), li3.getValue());
		
		LivingIndicator li4 = livingIndicatorRepository.findLastEntry(id);
		Assert.assertEquals(li4.getKey().getId(), li2.getKey().getId());
		Assert.assertEquals(li4.getKey().getDate(), li2.getKey().getDate());
		Assert.assertEquals(li4.getValue(), li2.getValue());
		
		LivingIndicator li5 = livingIndicatorRepository.findLastEntry(li3.getKey().getId());
		Assert.assertEquals(li5.getKey().getId(), li3.getKey().getId());
		Assert.assertEquals(li5.getKey().getDate(), li3.getKey().getDate());
		Assert.assertEquals(li5.getValue(), li3.getValue());
		
		
	}

}
