package service;

import java.util.List;

import po.Merchant;
import vo.MerchantVo;

public interface MerchantManager {

	public List<MerchantVo> findAll();
	public void registMerchant(Merchant m);
	public void updateMerchant(Merchant m);
	public void updateMerchantStatus(Merchant m);	
	public MerchantVo loadMerchant(String id);
	public Merchant loadMerchant1(String id);
	public void deleteMerchant(String id);	//shd be not used as joined with other class
	public boolean isExist(Merchant a);
	public Merchant findAdminByUsernameAndPassword(Merchant a);
	public void applyAdv(String id);
	
}
