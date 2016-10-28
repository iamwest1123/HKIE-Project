package test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import po.User;
import service.UserManager;

public class Test1 {
	
	@Test
	public void testGet() {
		//
		Client client = Client.create();
		client.setReadTimeout(1000);
		
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();
		params.add("merchantId", "1");		

		WebResource wr = client
				.resource("http://localhost:8080/Project3Admin/admin/checkMerchantStatus");
		
		String result = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)				
				.get(String.class);
		
		System.out.println(result);		
	}
	

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
