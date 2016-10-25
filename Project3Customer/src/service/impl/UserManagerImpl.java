package service.impl;

import java.util.List;

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
	public List<User> findAll() {
		return ud.findAll();
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
