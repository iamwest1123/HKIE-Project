package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.AddressDao;
import po.Address;
import po.Customer;

@Repository
public class AddressDaoImpl implements AddressDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public Address loadAddress(String id) {
		return em.find(Address.class, id);
	}

}
