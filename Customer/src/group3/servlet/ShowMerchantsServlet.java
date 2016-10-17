package group3.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group3.dao.MerchantInfoDao;
import group3.dao.impl.MerchantInfoDaoImpl;
import group3.po.Dish;
import group3.po.MerchantInfo;
import group3.service.ShowMerchantsService;
import group3.service.impl.ShowMerchantsServiceImpl;



@WebServlet("/showMerchants")
public class ShowMerchantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ShowMerchantsService md=new ShowMerchantsServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MerchantInfo> merchantInfos = new ArrayList<MerchantInfo>();
		
		//dishes = dd.getAllDishes(id);
		
//					MerchantInfo m = new MerchantInfo();
//					merchantInfos=md.findAllMerchantInfo();
		
					merchantInfos=md.showAcceptedMerchants();
					if(merchantInfos!=null){
					for(MerchantInfo merchantInfo : merchantInfos){
					}
					
					request.setAttribute("merchantsInfos", merchantInfos);
		
					}
					request.getRequestDispatcher("showMerchant.jsp").forward(request, response);
	}

}
