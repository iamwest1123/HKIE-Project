package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.CustomerOrder;
import po.Dish;
import service.OrderManager;

@Controller
@RequestMapping(value="order")
public class OrderController {

	@Autowired
	OrderManager om;
	
	@RequestMapping(value="/showOrder")
	@ResponseBody
	public List<CustomerOrder> showAllOrders(){
		List<CustomerOrder> list=om.findAll();
		List<CustomerOrder> ds=new ArrayList<CustomerOrder>();
		for(CustomerOrder d:ds){
			CustomerOrder d1=new CustomerOrder();
			BeanUtils.copyProperties(d1, d);
		ds.add(d1);
		}
		return list;
	}
	
	@RequestMapping(value="/showTest")
	@ResponseBody
	public CustomerOrder showTest(){
		List<CustomerOrder> list=om.findAll();
		List<CustomerOrder> ds=new ArrayList<CustomerOrder>();
		for(CustomerOrder d:ds){
			CustomerOrder d1=new CustomerOrder();
			BeanUtils.copyProperties(d1, d);
		ds.add(d1);
		}
		return list.get(2);
	}
}
