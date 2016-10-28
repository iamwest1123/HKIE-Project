package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.AdminAdvertDao;
import po.AdminAdvert;

@Repository
public class AdminAdvertDaoImpl implements AdminAdvertDao {

	@PersistenceContext(name="em")
	private EntityManager em;

	@Override
	public void addAdminAdv(AdminAdvert a) {
		em.persist(a);
	}

	@Override
	public List<AdminAdvert> findAllAdv() {
		String jpql = "from AdminAdvert";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public void updateAdminAdv(AdminAdvert u) {
		AdminAdvert aa = loadAdminAdv(u.getId());
//		aa.setBalance(u.getBalance());
//		aa.setExpireDate(u.getExpireDate());
//		aa.setStartDate(u.getStartDate());
		aa.setStatus(u.getStatus());
	}

	@Override
	public void deleteAdminAdv(String id) {
		AdminAdvert aa = loadAdminAdv(id);
		em.remove(aa);
	}

	@Override
	public AdminAdvert loadAdminAdv(String id) {
		return em.find(AdminAdvert.class, id);
	}

}
