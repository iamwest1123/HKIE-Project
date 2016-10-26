package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DishDao;
import po.Dish;
import po.Merchant;
import service.DishManager;

@Service
public class DishManagerImpl implements DishManager {

	@Autowired
	private DishDao ud;
	
	@Override
	@Transactional
	public void addDish(Dish d) {
		ud.addDish(d);

	}

	@Override
	public List<Dish> findAll() {
		return ud.findAll();
	}

	@Override
	public List<Dish> findDishByMerchants(Merchant m) {
		return ud.findDishByMerchants(m);
	}

	@Override
	@Transactional
	public void deleteDish(String id) {
		ud.deleteDish(id);

	}

	@Override
	@Transactional
	public Dish loadDish(String id) {
		return ud.loadDish(id);
	}

}
