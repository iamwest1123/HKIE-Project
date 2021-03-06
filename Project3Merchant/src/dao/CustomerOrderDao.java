package dao;

import java.util.Date;
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
	public boolean updateOrderStatus(String id, String status, Date deliveryDate);
	public void delOrder(String id);
	public boolean updateComment(String comment, double rating, String orderID);
}
