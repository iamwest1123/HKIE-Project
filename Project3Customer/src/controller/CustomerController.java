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
	public String logout() {
		return "redirect:login.html";
	}

	@RequestMapping(value="addCustomer")
	@ResponseBody
	public Customer addCustomer(Customer c){
		
		cm.registCustomer(c);
		return c;
	}
	
	@RequestMapping(value="loadCustomer")
	@ResponseBody
	public CustomerVo loadCustomer(String customerId){
		CustomerVo cvo = cm.loadCustomer(customerId);
		return cvo;
	}
	
	@RequestMapping(value="updateCustomer")
	@ResponseBody
	public String updateCustomer(Customer c,String Address1,String Address2,String Address3,String Region1,String Region2,String Region3){	
		Address add = new Address();
		add.setAddress(Address1);
		add.setAddress(Address2);
		add.setAddress(Address3);
		add.setAddress(Region1);
		add.setAddress(Region2);
		add.setAddress(Region3);
		
		add.setCustomer(c);
		c.getAddressList().add(add);
		
		cm.updateCustomer(c);
		return "true";	
	}
}
