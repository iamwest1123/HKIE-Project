package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Address;
import po.Merchant;
import service.MerchantManager;

@Controller
@RequestMapping(value="merchant")
public class MerchantController {

	@Autowired
	private MerchantManager mm;
	
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
}
