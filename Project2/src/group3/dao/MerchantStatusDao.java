package group3.dao;

import java.util.List;


import group3.po.MerchantStatus;

public interface MerchantStatusDao {

	public void addMerchantStatus(MerchantStatus ms);
	public void updateMerchantStatus(MerchantStatus ms);
	public void deleteMerchantStatus(int id);
	public MerchantStatus findMerchantStatus(int id);
	public List<MerchantStatus> findAllMerchantStatus();
}
