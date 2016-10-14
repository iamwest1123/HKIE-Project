package group3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group3.dao.MerchantStatusDao;
import group3.dao.impl.MerchantStatusDaoImpl;
import group3.po.MerchantStatus;
import group3.util.ProjectConstant;

@WebServlet("/removeBlacklist")
public class RemoveFromBlacklistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantStatusDao merchantStatusDao = new MerchantStatusDaoImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		MerchantStatus merchantStatus = merchantStatusDao.findMerchantStatus(id);
		merchantStatus.setStatus(ProjectConstant.MERCHANT_STATUS_ACCEPTED);
		merchantStatusDao.updateMerchantStatus(merchantStatus);
		response.sendRedirect("listMerchants");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
