package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import util.ProjectConstant;
import vo.AdminAdvertVo;

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
