package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.AdminDao;
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

	@Override
	public boolean isExist(Admin a) {
		String jpql = "from Admin WHERE loginName = ?";
		List<Admin> list = em.createQuery(jpql).setParameter(1, a.getLoginName()).getResultList();
		return (list.isEmpty()) ? false : true;
	}

	@Override
	public Admin findAdminByUsernameAndPassword(Admin a) {
		String jpql = "from Admin WHERE loginName = ? and password = ?";
		List<Admin> list = em.createQuery(jpql).setParameter(1, a.getLoginName()).setParameter(2, a.getPassword()).getResultList();
		return (list.isEmpty()) ? null : list.get(0);
	}

}
