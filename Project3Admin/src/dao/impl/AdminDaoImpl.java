package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.AdminDao;
import oracle.net.aso.i;
import po.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext(name = "em")
	private EntityManager em;

	@Override
	public void addAdmin(Admin a) {
		em.persist(a);
	}

	@Override
	public List<Admin> findAll() {
		String jpql = "from Admin";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public void updateAdmin(Admin u) {
		Admin a = loadAdmin(u.getId());
		a.setPassword(u.getPassword());
	}

	@Override
	public void deleteAdmin(String id) {
		Admin a = loadAdmin(id);
		em.remove(a);
	}

	@Override
	public Admin loadAdmin(String id) {
		Admin a = em.find(Admin.class, id);
		return a;
	}

}
