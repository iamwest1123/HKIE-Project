package service;

import po.AdminStatus;

public interface AdminStatusManager {
	public AdminStatus checkStatus(String merchantId);
}
