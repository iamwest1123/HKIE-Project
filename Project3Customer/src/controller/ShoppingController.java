package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		return sm.getShoppingCart(merchantId, session);
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
		return sm.setShoppingCart(merchantId, cart, session);
	}
	
	@RequestMapping(value="makeOrder")
	@ResponseBody
	public boolean makeOrder(String merchantId, String cartStr, HttpSession session) {
		ShoppingCart cart;
		try {
			cart = mapper.readValue(cartStr, ShoppingCart.class);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return sm.makeOrder(merchantId, cart, session);
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
	public List<Address> getCustomerAddress(String customerId) {
		return sm.getCustomerAddress(customerId);
	}
}
