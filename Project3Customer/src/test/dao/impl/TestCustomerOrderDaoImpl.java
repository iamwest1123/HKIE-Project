package test.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;

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
		CustomerOrderDao dao = context.getBean(CustomerOrderDaoImpl.class);
		CustomerOrder order = new CustomerOrder();
		order.setDeliverDate(new Date());
		order.setStatus(ProjectConstant.DELIVERY_STATUS_CANCELED);
		dao.addOrder(order);
	}
}
