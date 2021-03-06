package group3.service.impl;

import java.util.List;

import group3.dao.MerchantInfoDao;
import group3.dao.MerchantStatusDao;
import group3.dao.impl.MerchantInfoDaoImpl;
import group3.dao.impl.MerchantStatusDaoImpl;
import group3.mq.MerchantRegisterProducer;
import group3.po.MerchantInfo;
import group3.po.MerchantStatus;
import group3.service.MerchantManager;

public class MerchantManagerImpl implements MerchantManager {

	private MerchantInfoDao mi = new MerchantInfoDaoImpl();
	private MerchantRegisterProducer p = new MerchantRegisterProducer();
	
	
	@Override
	public void addMerchant(MerchantInfo m) {
		p.setMerchantInfo(m);
		p.send();
	}

	@Override
	public void updateMerchant(MerchantInfo m) {
		
		mi.updateMerchantInfo(m);
	}

	@Override
	public void deleteMerchant(int id) {
		
		mi.deleteMerchantInfo(id);
	}

	@Override
	public MerchantInfo loadMerchant(int id) {
		
		return mi.findMerchantInfo(id);
	}

	@Override
	public List<MerchantInfo> findAllMerchant() {
		
		return mi.findAllMerchantInfo();
	}

	@Override
	public MerchantInfo findMerchantInfoByName(String name) {

		return mi.findMerchantInfoByName(name);
	}

}
