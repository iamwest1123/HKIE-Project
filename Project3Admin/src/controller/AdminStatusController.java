package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.AdminStatus;
import service.AdminStatusManager;

@Controller
@RequestMapping(value="admin")
public class AdminStatusController {

	@Autowired
	private AdminStatusManager asm;
	
	@RequestMapping(value="checkMerchantStatus")
	@ResponseBody
	public AdminStatus checkMerchantStatus(String merchantId){		
		return asm.checkStatus(merchantId);
	}	
}
