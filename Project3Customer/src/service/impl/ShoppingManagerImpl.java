package service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DishDao;
import dao.MerchantDao;
import po.Comment;
import po.Dish;
import po.Merchant;
import service.ShoppingManager;
import util.ProjectConstant;
import vo.CommentVo;
import vo.MerchantVo;
import vo.ShoppingCart;

@Service
public class ShoppingManagerImpl implements ShoppingManager {
	@Autowired
	private DishDao udao;
	@Autowired
	private MerchantDao mdao;

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
