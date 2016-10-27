package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public List<Dish> showAllDishes(HttpServletRequest request){		
		
		HttpSession ses = request.getSession();
		String id = (String)ses.getAttribute(ProjectConstant.SESSION_ATTRIBUTE_MERCHANT_ID);
		
//		List<Dish> list=dm.findAll();
		List<Dish> list=dm.findDishByMerchants(mm.loadMerchant1(id));
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
	public void addDishes(Dish dish,HttpServletRequest request){
		
		HttpSession ses = request.getSession();
		String id = (String)ses.getAttribute("mid");
		
		Merchant m=mm.loadMerchant1(id);
		dish.setStatus(ProjectConstant.STATUS_ACCEPTED);
		dish.setMerchant(m);
		dm.addDish(dish);
	}
	
	
	
}
