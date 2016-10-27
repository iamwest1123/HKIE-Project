package test.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import dao.CustomerOrderDao;
import dao.DishDao;
import dao.MerchantDao;
import dao.impl.CustomerDaoImpl;
import dao.impl.CustomerOrderDaoImpl;
import dao.impl.DishDaoImpl;
import dao.impl.MerchantDaoImpl;
import po.Customer;
import po.CustomerOrder;
import po.Merchant;
import po.OrderDish;
import util.ProjectConstant;

public class TestCustomerOrderDaoImpl {

	@Test
	public void testAddOrder() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerOrderDao dao = (CustomerOrderDao) context.getBean(CustomerOrderDaoImpl.class);
		DishDao dd = (DishDao) context.getBean(DishDaoImpl.class);
		MerchantDao md=(MerchantDao) context.getBean(MerchantDaoImpl.class);
		CustomerDao cd = (CustomerDao) context.getBean(CustomerDaoImpl.class);
		CustomerOrder o = new CustomerOrder();
		o.setCustomer(cd.loadCustomer("4028b88157fffa970157fffa9b9e0002"));
		o.setDeliverDate(new Date());
		
		OrderDish od = new OrderDish();
		od.setDish(dd.loadDish("4028b88157fffa970157fffa9bc00006"));
		od.setQuantity(3);
		
		OrderDish od1 = new OrderDish();
		od1.setDish(dd.loadDish("8a5eb82658022e81015802322de30000"));
		od1.setQuantity(4);
				
		o.getDishes().add(od);
		o.getDishes().add(od1);
		
		od.setCustomerOrder(o);
		od1.setCustomerOrder(o);
		
		o.setMerchant(md.loadMerchant("8a5e9d1c57ffe8ca0158001650710004"));
		o.setOrderDate(new Date());
		o.setReceiveDate(new Date());
		o.setStatus(ProjectConstant.DELIVERY_STATUS_ORDERED);
		dao.addOrder(o);
	}
	
	// TODO: [Matthew] more test coverage 
	
	@Test
	public void testCompletetest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerOrderDao dao = (CustomerOrderDao) context.getBean(CustomerOrderDaoImpl.class);
		CustomerOrder order = new CustomerOrder();
		order.setDeliverDate(new Date());
		order.setStatus(ProjectConstant.DELIVERY_STATUS_CANCELED);
		dao.addOrder(order);
		List<CustomerOrder> li = dao.findAll();
		for (CustomerOrder co:li) {
			System.out.println(co.getId() +"..."+ co.getStatus());
		}
	}
	
	
	@Test
	public void testSearchByMerchant() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerOrderDao dao = (CustomerOrderDao) context.getBean(CustomerOrderDaoImpl.class);
		MerchantDao md=(MerchantDao) context.getBean(MerchantDaoImpl.class);
		List<CustomerOrder> lists=dao.findAllByMerchant(md.loadMerchant("4028b88157fffa970157fffa9b510000"));
		for (CustomerOrder co:lists) {
			System.out.println(co.getId() +"..."+ co.getStatus());
		}
		
		
		
	}
}
