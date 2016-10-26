package dao;

import java.util.List;

import po.Customer;

public interface CustomerDao {
	public void addCustomer(Customer c);
	public List<Customer> findAll();
	public void updateCustomer(Customer u);
	public void deleteCustomer(String id);
	public Customer loadCustomer(String id);
}
