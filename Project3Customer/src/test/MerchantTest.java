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

}
