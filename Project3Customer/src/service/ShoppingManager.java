package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import po.Address;
import po.Customer;
import po.Dish;
import po.Merchant;
import vo.CommentVo;
import vo.MerchantVo;
import vo.ShoppingCart;
import vo.ShoppingItem;

public interface ShoppingManager {
	public boolean makeOrder(String merchantId, String customerId, ShoppingCart cart, HttpSession session);
	public List<Dish> getDish(String merchantId);
	public MerchantVo getShopInfo(String merchantId);
	public List<CommentVo> getShopComment(String merchantId);
	public List<Address> getCustomerAddress(String customerId);
}
