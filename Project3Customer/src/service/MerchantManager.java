package service;

import java.util.List;

import po.Merchant;

public interface MerchantManager {

	public List<Merchant> findAll();
	public void registMerchant(Merchant m);
	public void updateMerchant(Merchant m);
	public void deleteMerchant(String id);	//shd be not used as joined with other class
}
