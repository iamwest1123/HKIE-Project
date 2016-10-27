package dao;

import java.util.List;

import po.Customer;
import po.Merchant;

public interface CustomerDao {
	public void addCustomer(Customer c);
	public List<Customer> findAll();
	public void updateCustomer(Customer u);
	public void deleteCustomer(String id);
	public Customer loadCustomer(String id);
	//Login
	public Customer findAdminByUsernameAndPassword(Customer c);
	public boolean isExist(Customer c);
}
