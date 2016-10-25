package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import dao.UserDao;
import po.User;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public void addUser(User u) {
		em.persist(u);
	}

	@Override
	public List<User> findAll() {		
		return em.createQuery("select u from User u").getResultList();
	}

	@Override
	public void updateUser(User u) {		
		User u2 = em.getReference(User.class, u.getId());
		u2.setAge(u.getAge());
		u2.setUname(u.getUname());
		em.persist(u2);
	}

	@Override
	public void deleteUser(String id) {
		User u = em.getReference(User.class, id);
		em.remove(u);				
	}
	
}
