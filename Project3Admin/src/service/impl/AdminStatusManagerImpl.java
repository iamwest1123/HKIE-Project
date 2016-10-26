package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AdminStatusDao;
import po.AdminStatus;
import service.AdminStatusManager;

@Service
public class AdminStatusManagerImpl implements AdminStatusManager {
	
	@Autowired
	private AdminStatusDao asd;

	@Override
	@Transactional
	public AdminStatus checkStatus(String merchantId) {
		return asd.getStatus(merchantId);
	}

	@Override
	@Transactional
	public void addStatus(AdminStatus as) {
		asd.createStatus(as);;
	}

	@Override
	@Transactional
	public void updateStatus(AdminStatus as) {
		asd.updateStatus(as);
	}

}
