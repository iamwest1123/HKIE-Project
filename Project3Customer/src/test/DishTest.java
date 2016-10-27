package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DishDao;
import dao.MerchantDao;
import dao.impl.DishDaoImpl;
import dao.impl.MerchantDaoImpl;
import po.Dish;
import po.Merchant;
import util.ProjectConstant;

public class DishTest {

	
	@Test
	public void testCreate(){
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DishDao cd = context.getBean(DishDaoImpl.class);
		MerchantDao md= context.getBean(MerchantDaoImpl.class);
		Merchant m1=md.loadMerchant("8a5eb82657ff6c7f0157ff6c91b30000");
		Dish d=new Dish();
		d.setCategory("CHI");
		d.setDescription("rice inCHINstyle");
		d.setMerchant(m1);
		d.setPrice(200.0);
		d.setStatus(ProjectConstant.STATUS_ACCEPTED);
		cd.addDish(d);
		
		
	}
	
	@Test
	public void testShowByMerchants(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DishDao cd = context.getBean(DishDaoImpl.class);
		MerchantDao md= context.getBean(MerchantDaoImpl.class);
		Merchant m1=md.loadMerchant("4028b88157fffa970157fffa9b510000");
		List<Dish> ds=cd.findDishByMerchants(m1);
		for(Dish d:ds){
			System.out.println(d.getName()+"..."+d.getDescription());
		}
		
	}
	
	@Test
	public void testDelete(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DishDao cd = context.getBean(DishDaoImpl.class);
		cd.deleteDish("8a5eb82657ff6dba0157ff6dca3d0000");
	
	}
	
	@Test
	public void testLoad(){
			
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			DishDao cd = context.getBean(DishDaoImpl.class);
			Dish d=cd.loadDish("8a5eb82657ff6d8d0157ff6d9dac0000");
			System.out.println(d.getId());
		}
	
	
	@Test
	public void testShowAll(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DishDao cd = context.getBean(DishDaoImpl.class);
		List<Dish> ds=cd.findAll();
		for(Dish d:ds){
			System.out.println(d.getName()+"..."+d.getDescription());
		}
		
	}
	
	
	
}
