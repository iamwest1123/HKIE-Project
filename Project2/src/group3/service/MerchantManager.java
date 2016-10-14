package group3.service;

import java.util.List;

import group3.po.MerchantInfo;


public interface MerchantManager {
	
	public void addMerchant(MerchantInfo u);
	public void updateMerchant(MerchantInfo u);
	public void deleteMerchant(int id);
	public MerchantInfo loadMerchant(int id);
	public List<MerchantInfo> findAllMerchant();
}
