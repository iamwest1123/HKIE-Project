package service;

import po.Customer;

public interface CustomerManager {
	public boolean isExist(Customer c);
	public Customer findAdminByUsernameAndPassword(Customer c);
}
