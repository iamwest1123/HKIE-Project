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
				setAdminId(admin.getId(),request.getSession());
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
	public Admin createAdmin(Admin a) {
		System.out.println("in create....");
		am.addAdmin(a);
		return a;
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public Admin editAdmin(Admin a,HttpSession session) {
		a.setId(getAdminId(session));
		am.updateAdmin(a);
		return a;
	}
	
	@RequestMapping(value="updateStatus")
	@ResponseBody
	public MessageStatus updateStatus(AdminStatus as) {
		asm.updateStatus(as);
		return msm.createMessageStatus("success");
	}
	
	@RequestMapping(value="getAdminId")
	@ResponseBody
	public String getAdminId(HttpSession session) {
		Object obj = session.getAttribute("id");
		if (obj==null)
			return "";
		else
			return (String) obj;
	}
	
	@RequestMapping(value="setAdminId")
	@ResponseBody
	public boolean setAdminId(String adminId, HttpSession session) {
		session.setAttribute("id", adminId);
		return true;
	}
	
	@RequestMapping(value="getName")
	@ResponseBody
	public String getAdminName(HttpSession session) {
		String id = getAdminId(session);
		System.out.println(id);
		return am.loadAdmin(id).getLoginName();
	}
	
}
