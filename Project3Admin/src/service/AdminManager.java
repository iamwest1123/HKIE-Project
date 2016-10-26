package service;

import java.util.List;

import po.Admin;

public interface AdminManager {

	public void addAdmin(Admin a);
	public List<Admin> findAllAdmin();
	public void updateAdmin(Admin u);
	public void deleteAdmin(String id);
	public Admin loadAdmin(String id);
	public boolean isExist(Admin a);
	public Admin findAdminByUsernameAndPassword(Admin a);
}
