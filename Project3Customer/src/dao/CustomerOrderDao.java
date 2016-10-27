package dao;

import java.util.List;

import po.Customer;
import po.CustomerOrder;
import po.Merchant;

public interface CustomerOrderDao {
	public boolean addOrder(CustomerOrder o);
	public boolean updateOrder(CustomerOrder o);
	public boolean deleteOrder(CustomerOrder o);
	public CustomerOrder loadOrder(String id);
	public List<CustomerOrder> findAll();
	public List<CustomerOrder> findAllByCustomer(Customer c);
	public List<CustomerOrder> findAllByMerchant(Merchant m);
}
