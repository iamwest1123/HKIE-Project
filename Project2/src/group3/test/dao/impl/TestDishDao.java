package group3.test.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import group3.dao.DishDao;
import group3.dao.MerchantInfoDao;
import group3.dao.impl.DishDaoImpl;
import group3.dao.impl.MerchantInfoDaoImpl;
import group3.po.Dish;
import group3.po.MerchantInfo;

public class TestDishDao {

	private DishDao dd =new DishDaoImpl();
	
	@Test
	public void testAdd() {
		Dish dish =new Dish();
		dish.setDescription("good taste");
		dish.setDishPicUrl("www.google.com");
		dish.setMerchantId(4);
		dish.setName("fried rice");
		dish.setQty(20);
		dish.setValid("T");
		dish.setPrice(20);
		dd.addDish(dish);
		
	}
	
	@Test
	public void testUpdate() {
		Dish dish=dd.loadDish(2);
		dish.setDescription("good good taste");
		dish.setDishPicUrl("www.gmail.com");
		dish.setMerchantId(3);
		dish.setName("fried rice");
		dish.setQty(20);
		dish.setValid("T");
		dish.setPrice(20);
		dd.updateDish(dish);
	}

	@Test
	public void testDelete() {
		dd.deleteDish(4);
	}
	
	@Test
	public void testFindOne() {
		Dish d = dd.loadDish(5);
		Dish d1=dd.loadDish(4);
		Assert.assertTrue(d!=null);
		Assert.assertTrue(d1==null);
	}
	
	@Test
	public void testFindAll() {
		List<Dish> ds = dd.findAllDish();
		for(Dish d:ds) {
			System.out.print(d.getDescription()+" "+d.getDishId()+" "+d.getDishPicUrl()+" "+d.getMerchantId()+" "+d.getName()+" "+d.getPrice()+" "+d.getQty());
		}
	}
	
	@Test
	public void testFindMerchant() {
		List<Dish> ds = dd.findMerchantDish(3);
		for(Dish d:ds) {
			System.out.print(d.getDescription()+" "+d.getDishId()+" "+d.getDishPicUrl()+" "+d.getMerchantId()+" "+d.getName()+" "+d.getPrice()+" "+d.getQty());
		}
	}
	
}
