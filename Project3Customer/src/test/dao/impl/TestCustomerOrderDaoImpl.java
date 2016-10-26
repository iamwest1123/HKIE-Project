package test.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerOrderDao;
import dao.impl.CustomerOrderDaoImpl;
import po.Customer;
import po.CustomerOrder;
import po.Merchant;
import util.ProjectConstant;

public class TestCustomerOrderDaoImpl {

	@Test
	public void testAddOrder() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerOrderDao dao = (CustomerOrderDao) context.getBean(CustomerOrderDaoImpl.class);
		CustomerOrder order = new CustomerOrder();
		order.setDeliverDate(new Date());
		order.setStatus(ProjectConstant.DELIVERY_STATUS_CANCELED);
		dao.addOrder(order);
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
}
