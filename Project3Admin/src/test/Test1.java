package test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.User;
import service.UserManager;

public class Test1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserManager um = context.getBean(UserManager.class);
		User u = new User();
		u.setAge(21);
		u.setUname("tom");
		u.setPsd("134");
		um.regist(u);
	}

}
