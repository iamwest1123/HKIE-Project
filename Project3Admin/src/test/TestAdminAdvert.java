package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.AdminAdvert;
import service.AdminAdvertManager;

public class TestAdminAdvert {

	/**
	public void addAdminAdv(AdminAdvert a);
	public List<AdminAdvert> findAllAdv();
	public void updateAdminAdv(AdminAdvert u);
	public void deleteAdminAdv(String id);
	public AdminAdvert loadAdminAdv(String id);
	 */
	
	@Test
	public void testAdd() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminAdvertManager aam = context.getBean(AdminAdvertManager.class);
		AdminAdvert aa = new AdminAdvert();
		aa.setBalance(123);
		aa.setExpireDate(new Date());
		aa.setStartDate(new Date());
		aa.setMerchantId("1");
		aa.setStatus("TEST");
		aam.addAdminAdv(aa);
	}
	
	@Test
	public void testFindAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminAdvertManager aam = context.getBean(AdminAdvertManager.class);
		List<AdminAdvert> aas = aam.findAllAdv();
		for(AdminAdvert aa: aas) {
			System.out.println(aa.getBalance()+"..."+aa.getId()+"..."+aa.getMerchantId()+"..."+aa.getStatus()+"..."+aa.getExpireDate()+"..."+aa.getStartDate());
		}
	}

	@Test
	public void testUpdate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminAdvertManager aam = context.getBean(AdminAdvertManager.class);
		AdminAdvert aa = new AdminAdvert();
		aa.setBalance(1);
		aa.setStatus("GG");
		aa.setExpireDate(new Date());
		aa.setStartDate(new Date());
		aa.setMerchantId("2");
		aa.setId("8a5eb84e57ff65d00157ff65d6d40000");
		aam.updateAdminAdv(aa);
		testFindOne();
	}
	@Test
	public void testDelete() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminAdvertManager aam = context.getBean(AdminAdvertManager.class);
		aam.deleteAdminAdv("8a5eb84e57ff65d00157ff65d6d40000");
	}
	@Test
	public void testFindOne() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminAdvertManager aam = context.getBean(AdminAdvertManager.class);
		AdminAdvert aa = aam.loadAdminAdv("8a5eb84e57ff65d00157ff65d6d40000");
		System.out.println(aa.getBalance()+"..."+aa.getId()+"..."+aa.getMerchantId()+"..."+aa.getStatus()+"..."+aa.getExpireDate()+"..."+aa.getStartDate());
	}
}
