package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AdminDao;
import po.Admin;
import service.AdminManager;

@Service
public class AdminManagerImpl implements AdminManager {

	@Autowired
	private AdminDao ad;
	
	@Override
	@Transactional
	public void addAdmin(Admin a) {
		ad.addAdmin(a);
	}

	@Override
	@Transactional
	public List<Admin> findAllAdmin() {
		return ad.findAll();
	}

	@Override
	@Transactional
	public void updateAdmin(Admin a) {
		ad.updateAdmin(a);
	}

	@Override
	@Transactional
	public void deleteAdmin(String id) {
		ad.deleteAdmin(id);
	}

	@Override
	@Transactional
	public Admin loadAdmin(String id) {
		return ad.loadAdmin(id);
	}

}
