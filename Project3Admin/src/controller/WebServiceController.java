package controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import po.AdminAdvert;
import po.AdminStatus;
import service.AdminAdvertManager;
import service.AdminStatusManager;

@Controller
@RequestMapping(value="request")
public class WebServiceController {

	@Autowired
	private AdminStatusManager asm;
	@Autowired
	private AdminAdvertManager aam;
	
	@RequestMapping(value="status",method=RequestMethod.GET)
	@ResponseBody
	public String getMerchantStatus(String id) throws Exception{
		ObjectMapper om = new ObjectMapper();
		AdminStatus as = asm.checkStatus(id);
		return om.writeValueAsString(as);
	}
	
	@RequestMapping(value="advertisement") 
	@ResponseBody
	public String requestForAdv(AdminAdvert adv) throws Exception{
		//...
		return null;
	}
	
	@RequestMapping(value="merchantList")
	@ResponseBody
	private String getMerchantList() throws Exception {
		Client client = Client.create();
		client.setReadTimeout(100000);
		WebResource wr = client.resource("http://localhost:8080/Project3Customer/merchant/getAll");
		String result = wr.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		return result;
	}
	
}
