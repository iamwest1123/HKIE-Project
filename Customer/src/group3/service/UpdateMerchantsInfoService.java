package group3.service;

import group3.po.MerchantInfo;

public interface UpdateMerchantsInfoService {

	public void updateMerchantsInfo(MerchantInfo merchantInfo);
	public MerchantInfo findMerchantInfo(int id);
	
}
