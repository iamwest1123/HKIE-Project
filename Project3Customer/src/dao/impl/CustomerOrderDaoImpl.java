package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.CustomerOrderDao;
import po.Customer;
import po.CustomerOrder;
import po.Merchant;
import util.ProjectConstant;

public class CustomerOrderDaoImpl implements CustomerOrderDao{

	@PersistenceContext(name="em")
	private EntityManager em;

	@Override
	public boolean addOrder(CustomerOrder o) {
		em.persist(o);
		return false;
	}

	@Override
	public boolean updateOrder(CustomerOrder o) {
		CustomerOrder o2 = em.getReference(CustomerOrder.class, o.getId());
		// TODO copy o to o2
		o2.setComment(o.getComment());
		o2.setDishes(o.getDishes());
		o2.setReceiveDate(o.getReceiveDate());
		o2.setDeliverDate(o.getDeliverDate());
		o2.setOrderDate(o.getOrderDate());
		o2.setStatus(o.getStatus());
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
	public List<CustomerOrder> findAllByCustomer(Customer c) {
		return em.createQuery("select o from CustomerOrder o")
//				.setParameter(arg0, arg1)
				.setMaxResults(50)
				.getResultList();
	}

	@Override
	public List<CustomerOrder> findAllByMerchant(Merchant m) {
		return em.createQuery("select o from CustomerOrder o")
//				.setParameter(arg0, arg1)
				.setMaxResults(50)
				.getResultList();
	}
	

}
