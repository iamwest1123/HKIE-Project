package controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import po.AdminStatus;
import service.AdminStatusManager;

public class WebServiceController {

	@Autowired
	private AdminStatusManager am;
	
	@RequestMapping(value="test")
	public String getMerchant(String id) throws Exception{
//		Client client = Client.create();
//		client.setReadTimeout(1000);
//		WebResource wr = client.resource("http://localhost:8080/...");
//		
//		String result = wr
//				.accept(MediaType.APPLICATION_JSON_TYPE)				
//				.get(String.class);
//		
//		return result;
		ObjectMapper om = new ObjectMapper();
		AdminStatus as = am.checkStatus(id);
		return om.writeValueAsString(as);
	}
	
}
