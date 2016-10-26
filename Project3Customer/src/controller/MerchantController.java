package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Merchant;
import service.MerchantManager;

@Controller
@RequestMapping(value="merchant")
public class MerchantController {

	@Autowired
	private MerchantManager mm;
	
	@RequestMapping(value="addMerchant")
	@ResponseBody
	public Merchant addMerchart(Merchant m){
	
		mm.registMerchant(m);
		return m;
	}
}
