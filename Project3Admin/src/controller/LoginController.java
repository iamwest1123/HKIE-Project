package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import oracle.net.aso.e;
import po.Admin;
import service.AdminManager;

@Controller
public class LoginController {

	@Autowired
	private AdminManager am;

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	@ResponseBody
	public Admin login(Admin a) {
		if (am.isExist(a)) {
			Admin admin = am.findAdminByUsernameAndPassword(a);
			if(admin!=null)
				return admin;
			else 
				return null;
		} else 
			return null;
	}

}
