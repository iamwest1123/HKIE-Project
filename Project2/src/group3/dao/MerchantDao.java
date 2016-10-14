package group3.dao;

import java.util.List;
import group3.po.Merchant;

public interface MerchantDao {

	public void addMerchant(Merchant m);
	public void updateMerchant(Merchant m);
	public void deleteMerchant(int id);
	public Merchant findMerchant();
	public List<Merchant> findAllMerchant();
	
}
