package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import po.Dish;
import po.Merchant;
import vo.CommentVo;
import vo.MerchantVo;
import vo.ShoppingCart;
import vo.ShoppingItem;

public interface ShoppingManager {
	public ShoppingCart getShoppingCart(String merchantId, HttpSession session);
	public boolean setShoppingCart(String merchantId, ShoppingCart cart, HttpSession session);
	public boolean makeOrder(String merchantId, ShoppingCart cart, HttpSession session);
	public List<Dish> getDish(String merchantId);
	public MerchantVo getShopInfo(String merchantId);
	public List<CommentVo> getShopComment(String merchantId);
}
