package group3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group3.po.MerchantInfo;
import group3.service.MerchantManager;
import group3.service.impl.MerchantManagerImpl;

/**
 * Servlet implementation class RegMerchant
 */
@WebServlet("/regMerchant")
public class RegMerchant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MerchantManager mm = new MerchantManagerImpl();

	public RegMerchant() {
		super();
	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doPost(req, resp);
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mname = request.getParameter("mname");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String sname = request.getParameter("sname"); // shop name
		String logo = request.getParameter("logo");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		// may do for password later

		MerchantInfo mi = new MerchantInfo();
		mi.setMerchantName(mname);
		mi.setAge(age);
		mi.setGender(gender);
		mi.setShopName(sname);
		mi.setShopPicUrl(logo);
		mi.setTelNum(tel);
		mi.setAddress(addr);

		mm.addMerchant(mi);

		response.sendRedirect("afterRegister.jsp");// hv to change to Sunny's
										// page-ViewMerchant

	}

}
