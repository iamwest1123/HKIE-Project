package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Admin;
import po.AdminStatus;
import po.MessageStatus;
import service.AdminManager;
import service.AdminStatusManager;
import service.MessageStatusManager;
import service.impl.MessageStatusManagerImpl;

@Controller
@RequestMapping(value="admin")
public class AdminController {

	@Autowired
	private AdminManager am;
	@Autowired 
	private AdminStatusManager asm;
	
	@Autowired
	private MessageStatusManager msm;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public MessageStatus login(Admin a,HttpServletRequest request) throws Exception {
		if (am.isExist(a)) {
			Admin admin = am.findAdminByUsernameAndPassword(a);
			if (admin != null) {
				HttpSession ses = request.getSession();
				ses.setAttribute("id", admin.getId());
				return msm.createMessageStatus("success");
			}	else
				return msm.createMessageStatus("fail", "Incorrect Password");
		} else
			return msm.createMessageStatus("fail", "Username not found! Please make sure that username is correct!");
	}

	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
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

	@RequestMapping(value="updateStatus")
	@ResponseBody
	public MessageStatus updateStatus(AdminStatus as) {
		asm.updateStatus(as);
		return msm.createMessageStatus("success");
	}
	
}
