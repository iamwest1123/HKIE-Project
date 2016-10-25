package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.User;
import service.UserManager;

@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	private UserManager um;
	
	@RequestMapping(value="listUsers")
	@ResponseBody
	public List<User> listUsers(){		
		return um.findAll();
	}
	
	
	@RequestMapping(value="addUser")
	@ResponseBody
	public User addUser(User u){		
		um.regist(u);		
		return u;
	}
	
	@RequestMapping(value="updateUser")
	@ResponseBody
	public String updateUser(String id, String uname, String age){
		int _age = Integer.parseInt(age);
		
		User u = new User();
		u.setId(id);
		u.setAge(_age);
		u.setUname(uname);
		
		um.updateUser(u);
		return "true";
	}
	
	@RequestMapping(value="deleteUser")
	@ResponseBody
	public String deleteUser(String id){
		um.deleteUser(id);
		return "true";
	}
}
