package test.dao.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DishDao;
import dao.MerchantDao;
import dao.impl.DishDaoImpl;
import dao.impl.MerchantDaoImpl;
import po.Dish;
import po.Merchant;

public class TestDishDaoImpl {
	@Test
	public void testListDish() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DishDao cd = context.getBean(DishDaoImpl.class);
		MerchantDao md= context.getBean(MerchantDaoImpl.class);
//		Merchant m1=md.loadMerchant("8a5eb82657ff6c7f0157ff6c91b30000");
		List<Dish> ds=cd.findDishByMerchantId("4028b88157fffa970157fffa9b510000");
		for(Dish d:ds){
			System.out.println(d.getName()+"..."+d.getDescription());
		}
	}
}
