package controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class WebServiceController {

	
	public String getMerchant() {
//		Client client = Client.create();
//		client.setReadTimeout(1000);
//		WebResource wr = client.resource("http://localhost:8080/...");
//		
//		String result = wr
//				.accept(MediaType.APPLICATION_JSON_TYPE)				
//				.get(String.class);
//		
//		return result;
		return "{\"merchantName\":\"Test\",\"shopName\":\"Test\",\"status\":\"UnderReview\"}";
	}
	
}
