package service;

import java.util.Date;
import java.util.List;

import po.CustomerOrder;
import po.Dish;
import po.Merchant;

public interface OrderManager {

	public List<CustomerOrder> findAll();
	public List<CustomerOrder> findOrderByMerchants(Merchant m);
	public CustomerOrder loadOrder(String id);
	public void updateCustomerOrder(CustomerOrder co);
	public void updateCustomerStatus(String id, String status, Date deliveryDate);
	
}
