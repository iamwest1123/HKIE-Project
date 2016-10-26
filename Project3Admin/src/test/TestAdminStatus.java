package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Admin;
import po.AdminAdvert;
import po.AdminStatus;
import service.AdminManager;
import service.AdminStatusManager;

public class TestAdminStatus {

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
		AdminStatusManager asm = context.getBean(AdminStatusManager.class);
		AdminStatus as = new AdminStatus();
		as.setStatus("Active");
		as.setType("Customer");
		asm.addStatus(as);
	}
	
	@Test
	public void testFind() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminStatusManager asm = context.getBean(AdminStatusManager.class);
		AdminStatus as = asm.checkStatus("8a5eb84e57ff611e0157ff61280f0000");
		System.out.println(as.getId() + "..." + as.getStatus() + "..." + as.getType());
	}

	@Test
	public void testUpdate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminStatusManager asm = context.getBean(AdminStatusManager.class);
		AdminStatus as = new AdminStatus();
		as.setId("8a5eb84e57ff611e0157ff61280f0000");
		as.setStatus("Deleted");
		asm.updateStatus(as);
		testFind();
	}
}
