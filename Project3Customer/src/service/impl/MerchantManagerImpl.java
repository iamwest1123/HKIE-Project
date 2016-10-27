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
	@Transactional
	public List<Merchant> findAll() {
		
		return md.findAllMerchant();
	}

	@Override
	@Transactional
	public void registMerchant(Merchant m) {
		
		md.addMerchant(m);
		
	}

	@Override
	@Transactional
	public void updateMerchant(Merchant m) {
		
		md.updateMerchantInfo(m);
	}

	@Override
	@Transactional
	public void deleteMerchant(String id) {
		
		md.deleteMerchant(id);
	}

	@Override
	@Transactional
	public Merchant loadMerchant(String id) {
		return md.loadMerchant(id);
	}

}
