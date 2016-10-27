package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import po.Customer;
import service.CustomerManager;

@Service
public class CustomerManagerImpl implements CustomerManager {

	@Autowired
	private CustomerDao cd;
	
	@Override
	@Transactional
	public boolean isExist(Customer c) {
		return cd.isExist(c);
	}

	@Override
	@Transactional
	public Customer findAdminByUsernameAndPassword(Customer c) {
		return cd.findAdminByUsernameAndPassword(c);
	}

	@Override
	public Customer load(String customerId) {
		return cd.loadCustomer(customerId);
	}

}
