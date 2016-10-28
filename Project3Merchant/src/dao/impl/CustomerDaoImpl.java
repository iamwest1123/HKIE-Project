package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import po.Customer;
import util.ProjectConstant;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	
	@Override
	@Transactional
	public void addCustomer(Customer c) {
		em.persist(c);
		
	}

	@Override
	public List<Customer> findAll() {
		String jpql="from Customer";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public void updateCustomer(Customer c) {
		Customer customer=em.find(Customer.class, c.getId());
		customer.setAddressList(c.getAddressList());
		customer.setCustomerOrderList(c.getCustomerOrderList());
		customer.setGender(c.getGender());
		customer.setLoginName(c.getLoginName());
		customer.setName(c.getName());
		customer.setPassword(c.getPassword());
		customer.setProfilePic(c.getProfilePic());
//		em.persist(customer);
		em.merge(customer);
	}

	@Override
	public void deleteCustomer(String id) {
		Customer c=this.loadCustomer(id);
		c.setStatus(ProjectConstant.STATUS_DELETED);

	}

	@Override
	@Transactional
	public Customer loadCustomer(String id) {
		Customer c=em.find(Customer.class, id);
		return c;
	}

	@Override
	public Customer findAdminByUsernameAndPassword(Customer c) {
		String jpql = "from Customer WHERE loginName = ? and password = ?";
		List<Customer> list = em.createQuery(jpql).setParameter(1, c.getLoginName()).setParameter(2, c.getPassword()).getResultList();
		return (list.isEmpty()) ? null : list.get(0);
	}

	@Override
	public boolean isExist(Customer c) {
		String jpql = "from Customer WHERE loginName = ?";
		List<Customer> list = em.createQuery(jpql).setParameter(1, c.getLoginName()).getResultList();
		return (list.isEmpty()) ? false : true;
	}
	
}
