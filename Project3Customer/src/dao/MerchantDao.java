package dao;

import java.util.List;

import po.Merchant;

public interface MerchantDao {

	public void addMerchant(Merchant m);
	public List<Merchant> findAllMerchant();
	public void updateMerchantInfo(Merchant m);
	public void updateMerchantStatus(Merchant m);
	public void deleteMerchant(String id);
	public Merchant loadMerchant(String id);
}
