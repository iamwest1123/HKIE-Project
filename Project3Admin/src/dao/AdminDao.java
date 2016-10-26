package dao;

import java.util.List;

import po.Admin;

public interface AdminDao {

	public void addAdmin(Admin a);
	public List<Admin> findAll();
	public void updateAdmin(Admin u);
	public void deleteAdmin(String id);
	public Admin loadAdmin(String id);
	
}
