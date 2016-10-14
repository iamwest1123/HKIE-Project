package group3.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.bind.Util;

import group3.po.MerchantInfo;
import group3.service.UpdateMerchantsInfoService;
import group3.service.impl.UpdateMerchantsInfoServiceImpl;


/**
 * Servlet implementation class UpdateMerchantServlet
 */
@WebServlet("/UpdateMerchant")
public class UpdateMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
	UpdateMerchantsInfoService ums=new UpdateMerchantsInfoServiceImpl();
	
    public UpdateMerchantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		private Integer id;
//		private String merchantName;
//		private Integer age;
//		private String gender;
//		private Date registerTime;
//		private String shopName;
//		private String telNum;
//		private String address;
//		private String shopPicUrl;
		
		String merchantName= request.getParameter("merchantName");
		String gender= request.getParameter("gender");
		String shopName= request.getParameter("shopName");
		String telNum= request.getParameter("telNum");
		String address= request.getParameter("address");
		String shopPicUrl= request.getParameter("shopPicUrl");
		int age=Integer.parseInt(request.getParameter("age"));
		int id= Integer.parseInt(request.getParameter("id"));
		String registerTimeString= request.getParameter("registerTime");
		java.util.Date d = null;
		long registTimeLong =0;
		Date registTime=null;
		try {
			d =  f.parse(registerTimeString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(d!=null){
		 registTimeLong= d.getTime();
		 registTime = new Date(registTimeLong);
		}
				
		
		MerchantInfo m = new MerchantInfo();
		m.setId(id);
		m.setAge(age);
		m.setMerchantName(merchantName);
		m.setGender(gender);
		m.setRegisterTime(registTime);
		m.setShopName(shopName);
		m.setTelNum(telNum);
		m.setAddress(address);
		m.setShopPicUrl(shopPicUrl);
		
		//add MQ here
		
		response.sendRedirect("myProfile");
	}

}
