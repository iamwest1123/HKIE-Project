package service;

import java.util.List;

import po.User;

public interface UserManager {
	public List<User> findAll();
	public void regist(User u);
	public void updateUser(User u);
	public void deleteUser(String id);
}
