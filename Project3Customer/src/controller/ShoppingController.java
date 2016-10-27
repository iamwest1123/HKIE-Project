package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import po.Address;
import po.Customer;
import po.Dish;
import po.Merchant;
import service.ShoppingManager;
import util.ProjectConstant;
import vo.CommentVo;
import vo.MerchantVo;
import vo.ShoppingCart;
import vo.ShoppingItem;

@Controller
@RequestMapping(value="shop")
public class ShoppingController {
	@Autowired
	private ShoppingManager sm;
	private ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(value="getShoppingCart")
	@ResponseBody
	public ShoppingCart getShoppingCart(String merchantId, HttpSession session) {
		Object obj = session.getAttribute(ProjectConstant.SESSION_ATTRIBUTE_SHOPPING_CART);
		if (obj==null)
			return new ShoppingCart();
		Map<String,ShoppingCart> cartMap = (HashMap<String,ShoppingCart>) obj;
		return cartMap.get(merchantId);
	}
	
	@RequestMapping(value="setShoppingCart")
	@ResponseBody
	public boolean setShoppingCart(String merchantId, String cartStr, HttpSession session) {
		ShoppingCart cart;
		try {
			cart = mapper.readValue(cartStr, ShoppingCart.class);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
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
	
	@RequestMapping(value="makeOrder")
	@ResponseBody
	public String makeOrder(String merchantId, String cartStr, HttpSession session) {
		ShoppingCart cart;
		String customerId;
		try {
			cart = mapper.readValue(cartStr, ShoppingCart.class);
			Object obj = session.getAttribute(ProjectConstant.SESSION_ATTRIBUTE_CUSTOMER_ID);
			if (obj==null)
				customerId = null;
			else
				customerId = (String) obj;
			sm.makeOrder(merchantId, customerId, cart, session);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:CustomerOrderHistory.html";
	}

	@RequestMapping(value="getShopDishes")
	@ResponseBody
	public List<Dish> getShopDishes(String merchantId) {
		return sm.getDish(merchantId);
	}

	@RequestMapping(value="getShopInfo")
	@ResponseBody
	public MerchantVo getShopInfo(String merchantId) {
		return sm.getShopInfo(merchantId);
	}
	
	@RequestMapping(value="getShopComment")
	@ResponseBody
	public List<CommentVo> getShopComment(String merchantId) {
		return sm.getShopComment(merchantId);
	}
	
	@RequestMapping(value="getCustomerAddress")
	@ResponseBody
	public List<Address> getCustomerAddress(HttpSession session) {
		String customerId = null;
		Object obj = session.getAttribute(ProjectConstant.SESSION_ATTRIBUTE_CUSTOMER_ID);
		if (obj!=null) {
			customerId = (String) obj;
			return sm.getCustomerAddress(customerId);
		} else
			return null;
	}
}
