package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Dish;
import po.Merchant;
import service.ShoppingManager;
import vo.MerchantVo;
import vo.ShoppingCart;

@Controller
@RequestMapping(value="shop")
public class ShoppingController {
	@Autowired
	private ShoppingManager sm;
	
	@RequestMapping(value="getShoppingCart")
	@ResponseBody
	public ShoppingCart getShoppingCart(String merchantId, HttpSession session) {
		return sm.getShoppingCart(merchantId, session);
	}
	
	@RequestMapping(value="setShoppingCart")
	@ResponseBody
	public boolean setShoppingCart(String merchantId, ShoppingCart cart, HttpSession session) {
		return sm.setShoppingCart(merchantId, cart, session);
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
}
