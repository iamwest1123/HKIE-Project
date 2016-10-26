package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.AdminStatusDao;
import po.AdminStatus;

@Repository
public class AdminStatusDaoImpl implements AdminStatusDao {
	
	@PersistenceContext(name="em")
	private EntityManager em;

	@Override
	public void createStatus(AdminStatus s) {
		em.persist(s);
	}

	@Override
	public void updateStatus(AdminStatus s) {
		AdminStatus as = getStatus(s.getId());
		as.setStatus(s.getStatus());
	}

	@Override
	public AdminStatus getStatus(String id) {
		return em.find(AdminStatus.class, id);
	}

}
