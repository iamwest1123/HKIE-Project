package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.DishDao;
import po.Dish;
import po.Merchant;
import util.ProjectConstant;

@Repository
public class DishDaoImpl implements DishDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	@Transactional
	public void addDish(Dish d) {
		em.persist(d);

	}

	@Override
	public List<Dish> findAll() {
		String jpql="from Dish";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public void deleteDish(String id) {
		Dish d=this.loadDish(id);
		d.setStatus(ProjectConstant.STATUS_ACCEPTED);

	}

	@Override
	public Dish loadDish(String id) {
		Dish d=em.find(Dish.class, id);
		return d;
	}

	@Override
	public List<Dish> findDishByMerchants(Merchant m) {
		String jpql="select d from Dish d where d.merchant=:mid";
		List<Dish> dishes=em.createQuery(jpql)
				.setParameter("mid", m.getId())
				.getResultList();
		return dishes;
	}

}
