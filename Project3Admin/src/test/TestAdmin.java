package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Admin;
import service.AdminManager;

public class TestAdmin {

	@Test
	public void testAdd() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminManager am = context.getBean(AdminManager.class);
		Admin admin = new Admin();
		admin.setLoginName("TestName");
		admin.setPassword("password");
		Admin admin2 = new Admin();
		admin2.setLoginName("TestName2");
		admin2.setPassword("password2");
		am.addAdmin(admin2);
	}

	@Test
	public void testFindAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminManager am = context.getBean(AdminManager.class);
		List<Admin> admins = am.findAllAdmin();
		for (Admin a : admins) {
			System.out.println(a.getId() + "..." + a.getLoginName() + "..." + a.getPassword());
		}
	}

	@Test
	public void testFindOne() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminManager am = context.getBean(AdminManager.class);
		Admin a = am.loadAdmin("8a5eb84e57ff1ef70157ff1efce60000");
		System.out.println(a.getId() + "..." + a.getLoginName() + "..." + a.getPassword());
	}

	@Test
	public void testUpdate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminManager am = context.getBean(AdminManager.class);
		Admin a = new Admin();
		a.setId("8a5eb84e57ff1ef70157ff1efce60000");
		a.setPassword("updatePassword");
		am.updateAdmin(a);
		Admin a1 = am.loadAdmin("8a5eb84e57ff1ef70157ff1efce60000");
		System.out.println(a1.getId() + "..." + a1.getLoginName() + "..." + a1.getPassword());
	}

	@Test
	public void testDelete() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminManager am = context.getBean(AdminManager.class);
		am.deleteAdmin("8a5eb84e57ff1ef70157ff1efce60000");
	}
}
