package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerOrderDao;
import po.CustomerOrder;
import po.Merchant;
import service.OrderManager;


@Service
public class OrderManagerImpl implements OrderManager {

	@Autowired
	private CustomerOrderDao cd;
	
	
	@Override
	public List<CustomerOrder> findAll() {
		return cd.findAll();
	}

	@Override
	public List<CustomerOrder> findOrderByMerchants(Merchant m) {
		return cd.findAllByMerchant(m);
	}

	@Override
	public CustomerOrder loadOrder(String id) {
		return cd.loadOrder(id);
	}

	@Override
	public void updateCustomerOrder(CustomerOrder co) {
		cd.updateOrder(co);

	}

}
