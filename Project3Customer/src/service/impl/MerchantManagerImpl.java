package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MerchantDao;
import po.Merchant;
import service.MerchantManager;

@Service
public class MerchantManagerImpl implements MerchantManager{

	@Autowired
	private MerchantDao md;
	
	@Override
	public List<Merchant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void registMerchant(Merchant m) {
		
		md.addMerchant(m);
		
	}

	@Override
	public void updateMerchant(Merchant m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMerchant(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Merchant loadMerchant(String id) {
		return md.loadMerchant(id);
	}

}
