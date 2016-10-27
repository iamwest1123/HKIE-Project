package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import po.User;
import service.UserManager;

@Service
public class UserManagerImpl implements UserManager{
	
	@Autowired
	private UserDao ud;

	@Override
	@Transactional //transaction begin, commit, arround Aop, open em, close em
	public void regist(User u) {
		ud.addUser(u);
	}

	@Override
	@Transactional
	public List<User> findAll() {
		
		List<User> us=ud.findAll();
		
		List<User> us1= new ArrayList<User>();
		for(User u:us){
			User u1= new User();
			try {
//				BeanUtils.getProperty(u, "tels");
				BeanUtils.copyProperties(u1, u);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			us1.add(u1);
			
			
		}
		
		//return ud.findAll();
		return us1;
		
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		ud.updateUser(u);
	}

	@Override
	@Transactional
	public void deleteUser(String id) {
		ud.deleteUser(id);
	}
	
}
