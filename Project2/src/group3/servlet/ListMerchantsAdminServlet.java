package group3.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group3.po.MerchantInfo;
import group3.po.MerchantStatus;
import group3.service.AdminService;
import group3.service.impl.AdminServiceImpl;

@WebServlet("/listMerchants")
public class ListMerchantsAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<MerchantInfo> infoList = approvalService.findUnapprovalMerchants();
//		request.setAttribute("infoList", infoList);
//		request.getRequestDispatcher("viewApprovalList.jsp").forward(request, response);
		LinkedHashMap<MerchantInfo,MerchantStatus> merchantsList = adminService.findAllMerchant();
		request.setAttribute("merchantsList", merchantsList);
		request.getRequestDispatcher("viewMerchantList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
