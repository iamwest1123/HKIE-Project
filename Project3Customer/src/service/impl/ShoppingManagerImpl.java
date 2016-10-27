package service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AddressDao;
import dao.CustomerDao;
import dao.CustomerOrderDao;
import dao.DishDao;
import dao.MerchantDao;
import po.Address;
import po.Comment;
import po.Customer;
import po.CustomerOrder;
import po.Dish;
import po.Merchant;
import po.OrderDish;
import service.ShoppingManager;
import util.ProjectConstant;
import vo.CommentVo;
import vo.MerchantVo;
import vo.ShoppingCart;
import vo.ShoppingItem;

@Service
public class ShoppingManagerImpl implements ShoppingManager {
	@Autowired
	private DishDao udao;
	@Autowired
	private MerchantDao mdao;
	@Autowired
	private CustomerDao cdao;
	@Autowired
	private CustomerOrderDao odao;
	@Autowired
	private DishDao ddao;
	@Autowired
	private AddressDao adao;

	@Override
	public boolean makeOrder(String merchantId, String customerId, ShoppingCart cart, HttpSession session) {
		CustomerOrder co = new CustomerOrder();
		if (customerId==null) 
			co.setCustomer(cdao.loadCustomer("4028b88157fffa970157fffa9b9e0002"));
		else 
			co.setCustomer(cdao.loadCustomer(customerId));
		co.setMerchant(mdao.loadMerchant(merchantId));
		co.setOrderDate(new Date());
		co.setStatus(ProjectConstant.DELIVERY_STATUS_ORDERED);
		co.setDeliveryAddr(adao.loadAddress(cart.getAddressId()));
		List<OrderDish> orderDishLi = new ArrayList<OrderDish>();
		OrderDish orderDish;
		for (ShoppingItem i : cart.getShoppingItems()) {
			orderDish = new OrderDish();
			orderDish.setDish(ddao.loadDish(i.getDishId()));
			orderDish.setQuantity(i.getQuantity());
			orderDishLi.add(orderDish);
			orderDish.setCustomerOrder(co);
		}
		co.setDishes(orderDishLi);
		
		odao.addOrder(co);
		return false;
	}

	@Override
	public List<Dish> getDish(String merchantId) {
		return udao.findDishByMerchantId(merchantId);
	}

	@Override
	@Transactional
	public MerchantVo getShopInfo(String merchantId) {
		Merchant m = mdao.loadMerchant(merchantId);
		MerchantVo vo = new MerchantVo(m);
		return vo;
	}

	@Override
	@Transactional
	public List<CommentVo> getShopComment(String merchantId) {
		Merchant m = mdao.loadMerchant(merchantId);
		List<CommentVo> voList = new ArrayList<CommentVo>();
		for (Comment c : m.getCommentList()) {
			voList.add(new CommentVo(c));
		}
		return voList;
	}

	@Override
	public List<Address> getCustomerAddress(String customerId) {
		Customer c = cdao.loadCustomer(customerId);
		List<Address> result = new ArrayList<Address>();
		List<Address> tmpList = c.getAddressList();
		Map<String, Boolean> tmpMap = new HashMap<String, Boolean>();
		for (Address a:tmpList) {
			if (!tmpMap.containsKey(a.getId())) {
				tmpMap.put(a.getId(), true);
				result.add(a);
			}
		}
		return result;
	}
}
