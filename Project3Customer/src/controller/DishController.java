package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Dish;
import po.Merchant;
import service.DishManager;
import service.MerchantManager;
import util.ProjectConstant;

@Controller
@RequestMapping(value="dish")
public class DishController {

	
	@Autowired
	private DishManager dm;
	
	@Autowired
	private MerchantManager mm;
	
	@RequestMapping(value="/showDishes")
	@ResponseBody
	public List<Dish> showAllDishes(){
		List<Dish> list=dm.findAll();
		List<Dish> ds=new ArrayList<Dish>();
		for(Dish d:ds){
			Dish d1=new Dish();
			BeanUtils.copyProperties(d1, d);
		ds.add(d1);
		}
		return list;
	}
	
	@RequestMapping(value="/delDishes")
	@ResponseBody
	public void delDishes(String id){
		dm.deleteDish(id);
	}
	
	
	@RequestMapping(value="/addDishes",method={RequestMethod.POST})
	@ResponseBody
	public void addDishes(Dish dish){
		Merchant m=mm.loadMerchant("4028b88157fffa970157fffa9b510000");
		dish.setStatus(ProjectConstant.STATUS_ACCEPTED);
		dish.setMerchant(m);
		dm.addDish(dish);
	}
	
	
	
}
