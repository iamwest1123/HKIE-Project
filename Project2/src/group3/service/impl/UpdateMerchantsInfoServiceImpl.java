package group3.service.impl;

import group3.dao.MerchantInfoDao;
import group3.dao.impl.MerchantInfoDaoImpl;
import group3.po.MerchantInfo;
import group3.service.UpdateMerchantsInfoService;

public class UpdateMerchantsInfoServiceImpl implements UpdateMerchantsInfoService {

	
	MerchantInfoDao md= new MerchantInfoDaoImpl();
	@Override
	public void updateMerchantsInfo(MerchantInfo merchantInfo) {

		md.updateMerchantInfo(merchantInfo);

	}
	@Override
	public MerchantInfo findMerchantInfo(int id) {
		return md.findMerchantInfo(id);
		
	}

}
