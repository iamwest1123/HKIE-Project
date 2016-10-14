package group3.dao;

import java.util.List;
import group3.po.MerchantInfo;

public interface MerchantInfoDao {

	public void addMerchant(MerchantInfo m);
	public void updateMerchant(MerchantInfo m);
	public void deleteMerchant(int id);
	public MerchantInfo findMerchant();
	public List<MerchantInfo> findAllMerchant();
	
}
