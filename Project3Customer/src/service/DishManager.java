package service;

import java.util.List;

import po.Dish;
import po.Merchant;

public interface DishManager {

	public void addDish(Dish d);
	public List<Dish> findAll();
	public List<Dish> findDishByMerchants(Merchant m);
	public void deleteDish(String id);
	public Dish loadDish(String id);
	
}
