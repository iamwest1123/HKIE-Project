package controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Address;
import po.Customer;
import po.Merchant;
import po.MessageStatus;
import service.CustomerManager;
import service.MessageStatusManager;
import util.ProjectConstant;
import vo.CustomerVo;
import vo.MerchantVo;

@Controller
@RequestMapping(value="customer")
public class CustomerController {

	@Autowired
	private CustomerManager cm;
	@Autowired
	private MessageStatusManager msm;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public MessageStatus login(Customer c, HttpServletRequest request) throws Exception {
		if (cm.isExist(c)) {
			Customer customer = cm.findAdminByUsernameAndPassword(c);
			if (customer != null) {
				HttpSession ses = request.getSession();
				ses.setAttribute(ProjectConstant.SESSION_ATTRIBUTE_CUSTOMER_ID, customer.getId());
				return msm.createMessageStatus("success");
			} else
				return msm.createMessageStatus("fail", "Incorrect Password");
		} else
			return msm.createMessageStatus("fail", "Username not found! Please make sure that username is correct!");
	}

	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request) {
	HttpSession session = request.getSession();
	session.invalidate();
	return "redirect:../loginC.html";
	}
	
//	@RequestMapping(value = "logout")
//	public String logout() {
//		return "redirect:login.html";
//	}

	@RequestMapping(value="addCustomer")
	@ResponseBody
	public Customer addCustomer(Customer c){
		
		cm.registCustomer(c);
		return c;
	}
	
	@RequestMapping(value="loadCustomer")
	@ResponseBody
	public CustomerVo loadCustomer(HttpServletRequest request){
		HttpSession ses = request.getSession();
		String id = (String)ses.getAttribute(ProjectConstant.SESSION_ATTRIBUTE_CUSTOMER_ID);

		System.out.println("........" + id+ "............");
		CustomerVo cvo = cm.loadCustomer(id);
		return cvo;
	}
	
	@RequestMapping(value="updateCustomer")
	@ResponseBody
	public String updateCustomer(HttpServletRequest request,Customer c,String Address1,String Address2,String Address3,String Region1,String Region2,String Region3){	
		HttpSession ses = request.getSession();
		String id = (String)ses.getAttribute(ProjectConstant.SESSION_ATTRIBUTE_CUSTOMER_ID);
	
		Customer c1=cm.loadCustomer1(id);
		c1.setName(c.getName());
		c1.setGender(c.getGender());
		c1.setProfilePic(c.getProfilePic());
		c1.setLoginName(c.getLoginName());
		System.out.println(Address1+".......................");
		System.out.println(Address2+".......................");
		System.out.println(Address3+".......................");
		Address add1 = new Address();
		Address add2 = new Address();
		Address add3 = new Address();
		add1.setAddress(Address1);
		add2.setAddress(Address2);
		add3.setAddress(Address3);
		add1.setRegion(Region1);
		add2.setRegion(Region2);
		add3.setRegion(Region3);
	
		add1.setCustomer(c1);
		add2.setCustomer(c1);
		add3.setCustomer(c1);
		c1.getAddressList().clear();
		if (add1.getAddress()==null || add1.getRegion()==null ||
				"".equals(add1.getAddress()) || "".equals(add1.getAddress()))
			c1.getAddressList().add(add1);
		if (add2.getAddress()==null || add2.getRegion()==null ||
				"".equals(add2.getAddress()) || "".equals(add2.getAddress()))
			c1.getAddressList().add(add2);
		if (add3.getAddress()==null || add3.getRegion()==null ||
				"".equals(add3.getAddress()) || "".equals(add3.getAddress()))
			c1.getAddressList().add(add3);
		
		
		cm.updateCustomer(c1);
		return "true";	
	}
}
