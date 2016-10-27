package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.AdminAdvert;

@Controller
public class AdminAdvertController {

	@RequestMapping(value="chooseAdvert", method=RequestMethod.GET)
	@ResponseBody
	public List<AdminAdvert> chooseAdvert(){
		AdminAdvert ad1 = new AdminAdvert();
		ad1.setMerchantId("4028b88157fffa970157fffa9b510000");
		
		AdminAdvert ad2 = new AdminAdvert();
		ad2.setMerchantId("8a5eb8265802341101580234919f0000");
		
		AdminAdvert ad3 = new AdminAdvert();
		ad2.setMerchantId("8a5e9d1c57ffe8ca0158001650710004");
		
		List<AdminAdvert> ads = new ArrayList<AdminAdvert>();
		ads.add(ad1);
		ads.add(ad2);
		ads.add(ad3);
		
		return ads;		
	}
}
