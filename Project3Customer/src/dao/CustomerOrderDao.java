package dao;

import java.util.List;

import po.CustomerOrder;

public interface CustomerOrderDao {
	public boolean addOrder(CustomerOrder o);
	public boolean updateOrder(CustomerOrder o);
	public boolean deleteOrder(CustomerOrder o);
	public boolean deleteOrder(String id);
	public List<CustomerOrder> findAllByCustomer();
	public List<CustomerOrder> findAllByMerchant();
}
