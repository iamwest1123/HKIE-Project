package group3.dao;

import java.util.List;

import group3.po.Dish;


public interface DishDao {

	public void addDish(Dish m);
	public void updateDish(Dish m);
	public void deleteDish(int id);
	public Dish findDish();
	public List<Dish> findAllDissh();
	
	
}
