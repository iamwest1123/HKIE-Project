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

import dao.CustomerDao;
import dao.CustomerOrderDao;
import dao.DishDao;
import dao.MerchantDao;
import po.Comment;
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

	@Override
	public ShoppingCart getShoppingCart(String merchantId, HttpSession session) {
		Object obj = session.getAttribute(ProjectConstant.SESSION_ATTRIBUTE_SHOPPING_CART);
		if (obj==null)
			return null;
		Map<String,ShoppingCart> cartMap = (HashMap<String,ShoppingCart>) obj;
		return cartMap.get(merchantId);
	}
	
	@Override
	public boolean setShoppingCart(String merchantId, ShoppingCart cart, HttpSession session) {
		Object obj = session.getAttribute(ProjectConstant.SESSION_ATTRIBUTE_SHOPPING_CART);
		Map<String,ShoppingCart> cartMap = null;
		if (obj==null)
			cartMap = new HashMap<String,ShoppingCart>();
		else
			cartMap = (HashMap<String,ShoppingCart>) obj;
		cartMap.put(merchantId, cart);
		session.setAttribute(ProjectConstant.SESSION_ATTRIBUTE_SHOPPING_CART, cartMap);
		return true;
	}

	@Override
	public boolean makeOrder(String merchantId, ShoppingCart cart, HttpSession session) {
		CustomerOrder co = new CustomerOrder();
		co.setCustomer(cdao.loadCustomer("4028b88157fffa970157fffa9b9e0002"));
		co.setMerchant(mdao.loadMerchant(merchantId));
		co.setOrderDate(new Date());
		co.setStatus(ProjectConstant.DELIVERY_STATUS_ORDERED);
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
}
