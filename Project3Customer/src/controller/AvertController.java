package controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import util.ProjectConstant;

@Controller
@RequestMapping(value="advert")
public class AvertController {
	
	@RequestMapping(value = "chooseAdvert")
	@ResponseBody
	public String chooseAdvert(){
		
		Client client = Client.create();
		client.setReadTimeout(1000);
		
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();		

		WebResource wr = client
				.resource(ProjectConstant.CHOOSE_ADV_WS_URL);
		
		String json = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)				
				.get(String.class);
		
		return json;
	}
}
