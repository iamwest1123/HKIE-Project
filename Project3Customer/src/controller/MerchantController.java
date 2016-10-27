package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import po.Address;
import po.Merchant;
import po.MessageStatus;
import service.MerchantManager;
import service.MessageStatusManager;
import util.ProjectConstant;
import vo.MerchantVo;

@Controller
@RequestMapping(value = "merchant")
public class MerchantController {

	@Autowired
	private MerchantManager mm;
	@Autowired
	private MessageStatusManager msm;

	@RequestMapping(value = "addMerchant")
	@ResponseBody
	public Merchant addMerchart(Merchant m, String address1, String region1) {

		System.out.println("........");
		System.out.println(address1);
		System.out.println("........");
		System.out.println(region1);

		Address add = new Address();
		add.setAddress(address1);
		add.setRegion(region1);
		m.setAddress(add);
		mm.registMerchant(m);
		return m;
	}

	@RequestMapping(value = "showMerchant")
	@ResponseBody
	public List<MerchantVo> showAllMerchants() {
		return mm.findAll();
	}

	@RequestMapping(value = "loadMerchant")
	@ResponseBody
	public MerchantVo loadMerchant(HttpServletRequest request) {
		HttpSession ses = request.getSession();
		String id = (String)ses.getAttribute("mid");
	
		
		MerchantVo mvo = mm.loadMerchant(id);
		return mvo;
	}

	@RequestMapping(value = "updateMerchant")
	@ResponseBody
	public String updateMerchant(HttpServletRequest request,Merchant m, String address1, String region1) {
		HttpSession ses = request.getSession();
		String id = (String)ses.getAttribute("mid");
	
		m.setId(id);
		Address add = new Address();
		add.setAddress(address1);
		add.setRegion(region1);
		m.setAddress(add);
		mm.updateMerchant(m);
		return "true";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public MessageStatus login(Merchant m, HttpServletRequest request) throws Exception {
		System.out.println(m.getLoginName());
		
		if (mm.isExist(m)) {
			System.out.println(m.getLoginName() + m.getPassword());
			Merchant merchant = mm.findAdminByUsernameAndPassword(m);
			if (merchant != null) {
				String result = getMerchantStatus(merchant.getId());
				
				HttpSession ses = request.getSession();
				ses.setAttribute(ProjectConstant.SESSION_ATTRIBUTE_MERCHANT_ID, merchant.getId());				
				
				return msm.createMessageStatus("success", result);
			} else
				return msm.createMessageStatus("fail", "Incorrect Password");
		} else {
			MessageStatus messageStatus = msm.createMessageStatus("fail",
					"Username not found! Please make sure that username is correct!");
			System.out.println(messageStatus.getStatus());
			return messageStatus;
		}
	}

	@RequestMapping(value = "logout")
	public String logout() {
		return "redirect:login.html";
	}

	@RequestMapping(value = "getAll")
	@ResponseBody
	public String requestForMerchantList() throws Exception{
		ObjectMapper om = new ObjectMapper();
		List<MerchantVo> list = mm.findAll();
		return om.writeValueAsString(list);
	}

	private String getMerchantStatus(String id) throws Exception {
		// like this?
		Client client = Client.create();
		client.setReadTimeout(1000);
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("id", id);
		WebResource wr = client.resource("http://localhost:8080/Project3Admin/request/status");
		String result = wr.queryParams(params).accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		System.out.println(result);
		return result;
	}

	private String requestAdv(String id) throws Exception {
		// NOT YET FINISH...
		Client client = Client.create();
		client.setReadTimeout(1000);
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		// params.add("id", id);
		WebResource wr = client.resource("http://localhost:8080/Project3Admin/request/advertisement");
		String result = wr.queryParams(params).accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		return result;
	}

		@RequestMapping(value="updateMerchantStatus")
	@ResponseBody
	public String updateMerchantStatus(Merchant m){
		mm.updateMerchantStatus(m);
		return "true";	
	}
		
		
		@RequestMapping(value="applyAds")
		@ResponseBody
		public String applyAds(String id,HttpServletRequest request){

			HttpSession ses = request.getSession();
			ses.setAttribute("mid", merchant.getId());		
			mm.applyAdv(id);
			
		}
		
	
}
