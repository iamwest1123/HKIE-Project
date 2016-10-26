package dao;

import po.AdminStatus;

public interface AdminStatusDao {

	public void createStatus(AdminStatus s);
	public void updateStatus(AdminStatus s);
	public AdminStatus getStatus(String id);

}
