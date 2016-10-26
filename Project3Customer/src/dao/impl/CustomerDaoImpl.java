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
	@Transactional
	public void updateCustomer(Customer c) {
		Customer customer=this.loadCustomer(c.getId());
		customer.setAddressList(c.getAddressList());
		customer.setCustomerOrderList(c.getCustomerOrderList());
		customer.setGender(c.getGender());
		customer.setLoginName(c.getLoginName());
		customer.setName(c.getName());
		customer.setPassword(c.getPassword());
		customer.setProfilePic(c.getProfilePic());
		customer.setStatus(c.getStatus());

	}

	@Override
	@Transactional
	public void deleteCustomer(String id) {
		Customer c=this.loadCustomer(id);
		c.setStatus(ProjectConstant.STATUS_DELETED);

	}

	@Override
	public Customer loadCustomer(String id) {
		Customer c=em.find(Customer.class, id);
		return c;
	}

}
