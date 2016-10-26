package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AdminStatusDao;
import po.AdminStatus;
import service.AdminStatusManager;

@Service
public class AdminStatusManagerImpl implements AdminStatusManager {
	
	@Autowired
	private AdminStatusDao asd;

	@Override
	public AdminStatus checkStatus(String merchantId) {
		// to do
		return asd.getStatus(merchantId);
	}

}
