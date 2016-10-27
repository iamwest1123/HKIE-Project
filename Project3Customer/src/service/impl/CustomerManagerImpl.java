package service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import po.Customer;
import po.Merchant;
import service.CustomerManager;
import vo.CustomerVo;

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
	@Transactional
	public void registCustomer(Customer c) {
		cd.addCustomer(c);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer c) {
		cd.updateCustomer(c);
	}

	@Override
	@Transactional
	public CustomerVo loadCustomer(String id) {

		Customer c = cd.loadCustomer(id);
		Customer c1 = new Customer();
		CustomerVo cvo = null;
		
		try {
			BeanUtils.getProperty(c, "addressList");			
			BeanUtils.getProperty(c, "customerOrderList");
			BeanUtils.copyProperties(c1, c);
			cvo = new CustomerVo(c1);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cvo;
	}

}
