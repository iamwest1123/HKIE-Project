package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Mmap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Customer;
import po.CustomerOrder;
import po.Dish;
import service.CustomerManager;
import service.MerchantManager;
import service.OrderManager;

@Controller
@RequestMapping(value="order")
public class OrderController {

	@Autowired
	OrderManager om;
	@Autowired
	CustomerManager cm;
	@Autowired
	MerchantManager mm;
	
	@RequestMapping(value="/showOrder")
	@ResponseBody
	public List<CustomerOrder> showAllOrders(HttpServletRequest request){
		
		HttpSession ses = request.getSession();
		String id = (String)ses.getAttribute("mid");
		System.out.println(id);
//		List<CustomerOrder> list=om.findAll();
		List<CustomerOrder> list=om.findOrderByMerchants(mm.loadMerchant1(id));
		List<CustomerOrder> ds=new ArrayList<CustomerOrder>();
		for(CustomerOrder d:ds){
			CustomerOrder d1=new CustomerOrder();
			BeanUtils.copyProperties(d1, d);
		ds.add(d1);
		}
		return list;
	}	
	
	@RequestMapping(value="/showOrderByCustomer")
	@ResponseBody
	public List<CustomerOrder> showOrderByCustomer(String customerId, HttpServletRequest request){
		
		HttpSession ses = request.getSession();
		ses.setAttribute("test", "abc");
		
		
		Customer c = cm.load(customerId);		
		List<CustomerOrder> list=om.findOrderByCustomer(c);
		List<CustomerOrder> ds=new ArrayList<CustomerOrder>();
		for(CustomerOrder d:ds){
			CustomerOrder d1=new CustomerOrder();
			BeanUtils.copyProperties(d1, d);
		ds.add(d1);
		}
		return list;
	}	
	
	@RequestMapping(value="/updateOrder",method = RequestMethod.POST)
	@ResponseBody
	public void updateOrders(CustomerOrder o){
	 	om.updateCustomerOrder(o);
	}
	
	@RequestMapping(value="/delOrder",method = RequestMethod.POST)
	@ResponseBody
	public void delOrder(String id){
	 	om.delOrder(id);
	}
	
	@RequestMapping(value="/updateStatus",method = RequestMethod.POST)
	@ResponseBody
	public void updateOrders(String id, String status, Date deliveryDate, HttpServletRequest request){
		
		HttpSession ses = request.getSession();
		System.out.println("sss");
		System.out.println(ses.getAttribute("test"));
		System.out.println(ses.getAttribute("mid"));		
	 	//om.updateCustomerStatus( id, status, deliveryDate);
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
