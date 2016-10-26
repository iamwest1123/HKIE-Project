package test;

import java.util.List;

import org.apache.tomcat.util.buf.UDecoder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import po.Customer;
import util.ProjectConstant;

public class CustomerTest {

	
	@Test
	public void testCreate(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao cd = context.getBean(CustomerDaoImpl.class);
		Customer c=new Customer();
		c.setGender(true);
		c.setLoginName("sunnylll");
		c.setName("Sunns");
		c.setPassword("000");
		c.setStatus(ProjectConstant.STATUS_ACCEPTED);
		cd.addCustomer(c);
		
		
	}
	
	@Test
	public void testShowAll(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao cd = context.getBean(CustomerDaoImpl.class);
		List<Customer> customers=cd.findAll();
		for(Customer c:customers){
			System.out.println(c.getName()+"..."+c.getStatus());
		}
		
		
	}
	
	@Test
	public void testUpdate(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao cd = context.getBean(CustomerDaoImpl.class);
		Customer c=new Customer();
		c.setGender(true);
		c.setLoginName("testUpdate");
		c.setName("Update");
		c.setPassword("0000");
		c.setStatus(ProjectConstant.STATUS_ACCEPTED);
		cd.addCustomer(c);
		c.setPassword("12345");
		c.setName("Pending");
		cd.updateCustomer(c);
		
	}
	
	@Test
	public void testLoad(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao cd = context.getBean(CustomerDaoImpl.class);
		Customer customer=cd.loadCustomer("8a5eb82657fec6610157fec6881c0000");
		
			System.out.println(customer.getName()+"..."+customer.getStatus());
	}
	
	@Test
	public void testDelete(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao cd = context.getBean(CustomerDaoImpl.class);
		cd.deleteCustomer("8a5eb82657fec6610157fec6881c0000");
		
	}
		
	
	
}
