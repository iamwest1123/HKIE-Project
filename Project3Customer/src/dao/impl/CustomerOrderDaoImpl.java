package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.CustomerOrderDao;
import po.CustomerOrder;

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
		em.persist(o2);
		return false;
	}

	@Override
	public boolean deleteOrder(CustomerOrder o) {
		CustomerOrder o2 = em.getReference(CustomerOrder.class, o.getId());
		o2.setStatus(status);
		em.persist(o2);
		return false;
	}

	@Override
	public boolean deleteOrder(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CustomerOrder> findAllByCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerOrder> findAllByMerchant() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
