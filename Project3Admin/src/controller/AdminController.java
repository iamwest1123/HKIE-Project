package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Admin;
import po.MessageStatus;
import service.AdminManager;
import service.MessageStatusManager;
import service.impl.MessageStatusManagerImpl;

@Controller
public class AdminController {

	@Autowired
	private AdminManager am;

	private MessageStatusManager msm;

	@RequestMapping(value = "loginAdmin", method = RequestMethod.POST)
	@ResponseBody
	public MessageStatus login(Admin a) throws Exception {
		msm = new MessageStatusManagerImpl();
		if (am.isExist(a)) {
			Admin admin = am.findAdminByUsernameAndPassword(a);
			if (admin != null)
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

	@RequestMapping(value = "showAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Admin> showAllAdmin() {
		System.out.println("in....");
		return am.findAllAdmin();
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public String createAdmin(Admin a) {
		System.out.println("in create....");
		am.addAdmin(a);
		return "Success";
	}

}
