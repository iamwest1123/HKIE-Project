package service;

import po.AdminStatus;

public interface AdminStatusManager {
	public AdminStatus checkStatus(String merchantId);
	public void addStatus(AdminStatus as);
	public void updateStatus(AdminStatus as);
}
