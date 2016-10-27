package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.MerchantDao;
import po.Merchant;

@Repository
public class MerchantDaoImpl implements MerchantDao{

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	@Transactional
	public void addMerchant(Merchant m) {		
		em.persist(m);
	}

	@Override
	public List<Merchant> findAllMerchant() {
		
		return em.createQuery("select m from Merchant m").getResultList();
	}

	@Override
	@Transactional
	public void updateMerchantInfo(Merchant m) {
		System.out.println(m.getId());
		
		Merchant m2 = em.find(Merchant.class, m.getId());
			
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
		m2.setAddress(m.getAddress()); //hv to think about embedded or not 

		
		em.persist(m2);
	}

	@Override
	@Transactional
	public void updateMerchantStatus(Merchant m) {

		Merchant m2 = em.getReference(Merchant.class, m.getId());
		
		m2.setStatus(m.getStatus());
		
		em.persist(m2);
	}
	
	@Override
	@Transactional
	public void deleteMerchant(String id) {
		
		Merchant m = em.find(Merchant.class, id);
		em.remove(m);
	}

	@Override
//	@Transactional
	public Merchant loadMerchant(String id) {
		System.out.println(em.find(Merchant.class, id).getLoginName());
		return em.find(Merchant.class, id);
	}

	@Override
	public Merchant findAdminByUsernameAndPassword(Merchant m) {
		String jpql = "from Merchant WHERE loginName = ? and password = ?";
		List<Merchant> list = em.createQuery(jpql).setParameter(1, m.getLoginName()).setParameter(2, m.getPassword()).getResultList();
		return (list.isEmpty()) ? null : list.get(0);
	}

	@Override
	public boolean isExist(Merchant m) {
		String jpql = "from Merchant WHERE loginName = ?";
		List<Merchant> list = em.createQuery(jpql).setParameter(1, m.getLoginName()).getResultList();
		return (list.isEmpty()) ? false : true;
	}



	
}
