package group3.dao;

import java.util.List;

import group3.po.Dish;


public interface DishDao {

	public void addDish(Dish m);
	public void updateDish(Dish m);
	public void deleteDish(int id);
	public Dish loadDish(int id);
	public List<Dish> findAllDish();
	public List<Dish> findMerchantDish(int id);
	
	
}
