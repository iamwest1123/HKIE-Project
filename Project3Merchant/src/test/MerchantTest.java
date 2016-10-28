package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import dao.MerchantDao;
import dao.impl.CustomerDaoImpl;
import dao.impl.MerchantDaoImpl;
import po.Address;
import po.Customer;
import po.Merchant;
import util.ProjectConstant;

public class MerchantTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantDao cd = context.getBean(MerchantDaoImpl.class);		
		
		Merchant m=new Merchant();
		m.setLoginName("ryanbb");
		m.setCanPreOrder(true);
		m.setGender(true);
		
		Address add = new Address();
		add.setAddress("hong kong");
		add.setRegion("hk");		
		m.setAddress(add);		
		
		cd.addMerchant(m);		
	}

	@Test
	public void testfindAllMerchant(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantDao cd = context.getBean(MerchantDaoImpl.class);		
		
		cd.findAllMerchant();
		
	}
	
	@Test
	public void testupdateMerchantInfo(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantDao cd = context.getBean(MerchantDaoImpl.class);		
		
		Merchant m=new Merchant();
		m.setId("8a5e9d1c57ff6c100157ff6c156c0000");
		m.setLoginName("BigRyanBB");
		m.setCanPreOrder(true);
		m.setGender(true);
		
		Address add = new Address();
		add.setAddress("hong kong");
		add.setRegion("Asia");		
		m.setAddress(add);	
		
		cd.updateMerchantInfo(m);
	}
	
	@Test
	public void testupdateMerchantStatus(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantDao cd = context.getBean(MerchantDaoImpl.class);		
		
//		ProjectConstant pc = new ProjectConstant();
		
		Merchant m=new Merchant();
		m.setId("8a5eb82657ff6c4d0157ff6c5c8d0000");
		m.setStatus("Forzen");
		
		cd.updateMerchantStatus(m);
	}
	
	@Test
	public void testdeleteMerchant(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantDao cd = context.getBean(MerchantDaoImpl.class);		
		

		cd.deleteMerchant("001");
	}
	
	@Test
	public void testloadMerchant(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantDao cd = context.getBean(MerchantDaoImpl.class);		
		
		cd.loadMerchant("8a5eb82657ff6c4d0157ff6c5c8d0000");
	}
}
