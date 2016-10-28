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
	@Transactional
	public List<Dish> findAll() {
		String jpql="select d from Dish d where d.status=:st";
		List<Dish> dishes=em.createQuery(jpql).setParameter("st", ProjectConstant.STATUS_ACCEPTED).getResultList();
		return dishes;
	}

	@Override
	@Transactional
	public void deleteDish(String id) {
		Dish d=this.loadDish(id);
		d.setStatus(ProjectConstant.STATUS_DELETED);

	}

	@Override
	@Transactional
	public Dish loadDish(String id) {
		Dish d=em.find(Dish.class, id);
		return d;
	}

	@Override
	@Transactional
	public List<Dish> findDishByMerchants(Merchant m) {
		String jpql="select d from Dish d where d.merchant=:m and d.status=:st";
		List<Dish> dishes=em.createQuery(jpql)
				.setParameter("m", m)
				.setParameter("st", ProjectConstant.STATUS_ACCEPTED)
				.getResultList();
		return dishes;
	}
	
	public List<Dish> findDishByMerchantId(String merchantId) {
		String jpql="select d from Dish d where d.merchant.id=:mid and d.status=:st";
		List<Dish> dishes=em.createQuery(jpql)
				.setParameter("mid", merchantId)
				.setParameter("st", ProjectConstant.STATUS_ACCEPTED)
				.getResultList();
		return dishes;
	}

}
