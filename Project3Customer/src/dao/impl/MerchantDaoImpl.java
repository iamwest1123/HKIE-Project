package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.MerchantDao;
import po.Merchant;

public class MerchantDaoImpl implements MerchantDao{

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public void addMerchant(Merchant m) {
		
		em.persist(m);
	}

	@Override
	public List<Merchant> findAllMerchant() {
		
		return em.createQuery("select m from Merchant m").getResultList();
	}

	@Override
	public void updateMerchantInfo(Merchant m) {
		
		Merchant m2 = em.getReference(Merchant.class, m.getId());
		
		m2.setMerchantName(m.getMerchantName());
		m2.setShopName(m.getShopName());
		m2.setTelNum(m.getTelNum());
		m2.setShopPic(m.getShopPic());
		m2.setPassword(m.getPassword());
		m2.setLoginName(m.getLoginName());
		m2.setCategory(m.getCategory());
		m2.setOpeningHour(m.getOpeningHour());
		m2.setClosingHour(m.getClosingHour());
		m2.setGender(m.getGender());
		m2.setCanPreOrder(m.getCanPreOrder());
		m2.setRegisterTime(m.getRegisterTime());
//		m2.setAddress(m.getAddress()); //hv to think about embedded or not 

		em.persist(m2);
	}

	@Override
	public void updateMerchantStatus(Merchant m) {

		Merchant m2 = em.getReference(Merchant.class, m.getId());
		
		m2.setStatus(m.getStatus());
		
		em.persist(m2);
	}
	
	@Override
	public void deleteMerchant(String id) {
		
		Merchant m = em.getReference(Merchant.class, id);
		em.remove(m);
	}



	
}
