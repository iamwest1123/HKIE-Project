package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
import po.Address;
import po.Comment;
import po.Customer;
import po.CustomerOrder;
import po.Dish;
import po.Merchant;
import po.OrderDish;
import util.ProjectConstant;

public class FakeDataTest {

	@Test
	@Transactional
	public void test() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantDao md = context.getBean(MerchantDaoImpl.class);
		CustomerDao cd = context.getBean(CustomerDaoImpl.class);
		CustomerOrderDao cod = context.getBean(CustomerOrderDaoImpl.class);
		DishDao dd = context.getBean(DishDaoImpl.class);
		
		
		Merchant m = new Merchant();
		m.setMerchantName("Ryan Merchant Name");
		m.setShopName("Ryan Shop");
		m.setTelNum("22338583");
		m.setShopName("kobe.png");
		m.setPassword("iloveoocl");
		m.setLoginName("ryanbb");
		m.setStatus(ProjectConstant.STATUS_ACCEPTED);
		m.setCategory(ProjectConstant.CATEGORY_CHINESE);
		m.setOpeningHour(9);
		m.setClosingHour(23);
		m.setGender(false);
		m.setCanPreOrder(true);
		
		Address a = new Address();
		a.setAddress("香港科技園");
		a.setRegion("香港");
		m.setAddress(a);
		
		Dish d = new Dish();
		d.setCategory("CHI");
		d.setDescription("rice inCHINstyle");
		d.setMerchant(m);
		d.setPrice(200.0);
		d.setStatus(ProjectConstant.STATUS_ACCEPTED);	
		m.getDishList().add(d);
		
		Dish d1 = new Dish();
		d1.setCategory("French Fries");
		d1.setDescription("Rubbish Food");
		d1.setMerchant(m);
		d1.setPrice(40.0);
		d1.setStatus(ProjectConstant.STATUS_ACCEPTED);	
		m.getDishList().add(d1);
		
		Customer c=new Customer();
		c.setGender(true);
		c.setLoginName("sunnylll");
		c.setName("Sunns");
		c.setPassword("000");
		c.setStatus(ProjectConstant.STATUS_ACCEPTED);
		
		Comment cm = new Comment();
		cm.setComment("Rubbish Food");
		cm.setCommentDate(new Date());
		cm.setCustomer(c);
		cm.setRating(1.0);
		cm.setReply("Our chef was sick that day. Please try again");
		cm.setReplyDate(new Date());
		
		m.getCommentList().add(cm);
		
		CustomerOrder o = new CustomerOrder();
		o.setComment(cm);
		o.setCustomer(c);
		o.setDeliverDate(new Date());
		
		OrderDish od = new OrderDish();
		od.setDish(d);
		od.setQuantity(3);
		
		OrderDish od1 = new OrderDish();
		od1.setDish(d1);
		od1.setQuantity(4);
				
		o.getDishes().add(od);
		o.getDishes().add(od1);
		
		od.setCustomerOrder(o);
		od1.setCustomerOrder(o);
		
		o.setMerchant(m);
		o.setOrderDate(new Date());
		o.setReceiveDate(new Date());
		o.setStatus("Delivered");				
		
		m.getCustomerOrderList().add(o);
		
		md.addMerchant(m);
		cd.addCustomer(c);
		cod.addOrder(o);
		dd.addDish(d);
		dd.addDish(d1);
	}

}
