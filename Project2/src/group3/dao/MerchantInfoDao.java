package group3.dao;

import java.util.List;
import group3.po.MerchantInfo;

public interface MerchantInfoDao {

	public void addMerchantInfo(MerchantInfo m);
	public void updateMerchantInfo(MerchantInfo m);
	public void deleteMerchantInfo(int id);
	public MerchantInfo findMerchantInfo(int id);
	public MerchantInfo findMerchantInfoByName(String name);
	public List<MerchantInfo> findAllMerchantInfo();
	
}
