package dao;

import java.util.List;

import po.Dish;
import po.Merchant;


public interface DishDao {

	public void addDish(Dish d);
	public List<Dish> findAll();
	public List<Dish> findDishByMerchants(Merchant m);
	public List<Dish> findDishByMerchantId(String merchantId);
	public void deleteDish(String id);
	public Dish loadDish(String id);
	
}
