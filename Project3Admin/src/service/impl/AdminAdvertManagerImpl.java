package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AdminAdvertDao;
import po.AdminAdvert;
import service.AdminAdvertManager;

@Service
public class AdminAdvertManagerImpl implements AdminAdvertManager {

	@Autowired
	private AdminAdvertDao aad;

	@Override
	@Transactional
	public void addAdminAdv(AdminAdvert a) {
		aad.addAdminAdv(a);
	}

	@Override
	@Transactional
	public void updateAdminAdv(AdminAdvert aa) {
		aad.updateAdminAdv(aa);
	}

	@Override
	@Transactional
	public void deleteAdminAdv(String id) {
		aad.deleteAdminAdv(id);
	}

	@Override
	@Transactional
	public AdminAdvert loadAdminAdv(String id) {
		return aad.loadAdminAdv(id);
	}

	@Override
	@Transactional
	public List<AdminAdvert> findAllAdv() {
		return aad.findAllAdv();
	}

}
