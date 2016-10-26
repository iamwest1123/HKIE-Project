package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Dish;
import service.DishManager;

@Controller
@RequestMapping(value="dish")
public class DishController {

	
	@Autowired
	private DishManager dm;
	
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
	
	
	
	
}
