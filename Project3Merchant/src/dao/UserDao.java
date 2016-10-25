package dao;

import java.util.List;

import po.User;

public interface UserDao {
	public void addUser(User u);
	public List<User> findAll();
	public void updateUser(User u);
	public void deleteUser(String id);
}
