package group3.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group3.po.MerchantInfo;
import group3.service.ApprovalService;
import group3.service.impl.ApprovalServiceImpl;

@WebServlet("/listUnapprove")
public class ListUnapproveMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApprovalService approvalService = new ApprovalServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MerchantInfo> infoList = approvalService.findUnapprovalMerchants();
		request.setAttribute("infoList", infoList);
		request.getRequestDispatcher("viewApprovalList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
