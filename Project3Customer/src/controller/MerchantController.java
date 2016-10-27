package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Address;
import po.Merchant;
import po.MessageStatus;
import service.MerchantManager;
import service.MessageStatusManager;
import vo.MerchantVo;

@Controller
@RequestMapping(value="merchant")
public class MerchantController {

	@Autowired
	private MerchantManager mm;
	@Autowired
	private MessageStatusManager msm;
	
	@RequestMapping(value="addMerchant")
	@ResponseBody
	public Merchant addMerchart(Merchant m,String address1,String region1){
	
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
	
	@RequestMapping(value="showMerchant")
	@ResponseBody
	public List<MerchantVo> showAllMerchants(){		
		return mm.findAll();	
	}
	
	@RequestMapping(value="loadMerchant")
	@ResponseBody
	public MerchantVo loadMerchant(String merchantId){
		MerchantVo mvo = mm.loadMerchant(merchantId);
		return mvo;
	}
	

	@RequestMapping(value = "loginMerchant", method = RequestMethod.POST)
	@ResponseBody
	public MessageStatus login(Merchant m) throws Exception {
		if (mm.isExist(m)) {
			Merchant merchant = mm.findAdminByUsernameAndPassword(m);
			if (merchant != null)
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
	
}
