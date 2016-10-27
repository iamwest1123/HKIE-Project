package service;

import po.Customer;
import po.Merchant;
import vo.CustomerVo;

public interface CustomerManager {
	public boolean isExist(Customer c);
	public Customer findAdminByUsernameAndPassword(Customer c);
	public void registCustomer(Customer c);
	public void updateCustomer(Customer c);
	public CustomerVo loadCustomer(String id);
}
