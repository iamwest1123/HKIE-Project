package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Customer;
import po.MessageStatus;
import service.CustomerManager;
import service.MessageStatusManager;
import vo.MerchantVo;

@Controller
@RequestMapping(value="customer")
public class CustomerController {

	@Autowired
	private CustomerManager cm;
	@Autowired
	private MessageStatusManager msm;
	
	@RequestMapping(value = "loginAdmin", method = RequestMethod.POST)
	@ResponseBody
	public MessageStatus login(Customer c) throws Exception {
		if (cm.isExist(c)) {
			Customer customer = cm.findAdminByUsernameAndPassword(c);
			if (customer != null)
				return msm.createMessageStatus("success");
			else
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
	
//	@RequestMapping(value="loadCustomer")
//	@ResponseBody
//	public MerchantVo loadCustomer(String merchantId){
//		MerchantVo mvo = mm.loadMerchant(merchantId);
//		return mvo;
//	}
}
