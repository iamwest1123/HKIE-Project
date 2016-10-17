package group3.service.impl;

import group3.dao.MerchantInfoDao;
import group3.dao.impl.MerchantInfoDaoImpl;
import group3.mq.MerchantRegisterProducer;
import group3.po.MerchantInfo;
import group3.service.UpdateMerchantsInfoService;

public class UpdateMerchantsInfoServiceImpl implements UpdateMerchantsInfoService {

	
	MerchantInfoDao md= new MerchantInfoDaoImpl();
	MerchantRegisterProducer p = new MerchantRegisterProducer();
	@Override
	public void updateMerchantsInfo(MerchantInfo merchantInfo) {

		p.setMerchantInfo(merchantInfo);
		p.send();

	}
	@Override
	public MerchantInfo findMerchantInfo(int id) {
		return md.findMerchantInfo(id);
		
	}

}
