package service;

import java.util.List;

import po.Merchant;
import vo.MerchantVo;

public interface MerchantManager {

	public List<MerchantVo> findAll();
	public void registMerchant(Merchant m);
	public void updateMerchant(Merchant m);
	public Merchant loadMerchant(String id);
	public void deleteMerchant(String id);	//shd be not used as joined with other class
}
