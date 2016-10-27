package dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerOrderDao;
import po.Customer;
import po.CustomerOrder;
import po.Merchant;
import util.ProjectConstant;

@Repository
public class CustomerOrderDaoImpl implements CustomerOrderDao{

	@PersistenceContext(name="em")
	private EntityManager em;

	@Override
	@Transactional
	public boolean addOrder(CustomerOrder o) {
		em.persist(o);
		return false;
	}

	@Override
	@Transactional
	public boolean updateOrder(CustomerOrder o) {
		CustomerOrder o2 = em.getReference(CustomerOrder.class, o.getId());
		// TODO copy o to o2
		o2.setComment(o.getComment());
		//o2.setDishes(o.getDishes());
		o2.setReceiveDate(o.getReceiveDate());
		o2.setDeliverDate(o.getDeliverDate());
		o2.setOrderDate(o.getOrderDate());
		o2.setStatus(o.getStatus());
		em.persist(o2);
		return false;
	}
	
	@Override
	@Transactional
	public boolean updateOrderStatus(String id, String status, Date deliveryDate) {
		CustomerOrder o2 = em.find(CustomerOrder.class, id);
		// TODO copy o to o2
		//o2.setDishes(o.getDishes());
		o2.setDeliverDate(deliveryDate);
		o2.setStatus(status);
		em.persist(o2);
		return false;
	}

	@Override
	public boolean deleteOrder(CustomerOrder o) {
		CustomerOrder o2 = em.getReference(CustomerOrder.class, o.getId());
		o2.setStatus(ProjectConstant.DELIVERY_STATUS_CANCELED);
		em.persist(o2);
		return false;
	}
	
	@Override
	public List<CustomerOrder> findAll() {
		return em.createQuery("select o from CustomerOrder o where not o.status = :st")
				.setParameter("st", ProjectConstant.STATUS_DELETED)
				.setMaxResults(100)
				.getResultList();
	}

	@Override
	public List<CustomerOrder> findAllByCustomer(Customer c) {
		return em.createQuery("select o from CustomerOrder o where o.customer = :cid")
				.setParameter("cid", c)
				.setMaxResults(100)
				.getResultList();
	}

	@Override
	public List<CustomerOrder> findAllByMerchant(Merchant m) {
		return em.createQuery("select o from CustomerOrder o where o.merchant = :mid")
				.setParameter("mid", m)
				.setMaxResults(100)
				.getResultList();
	}

	@Override
	public CustomerOrder loadOrder(String id) {
		return em.find(CustomerOrder.class, id);
	}
	

}
