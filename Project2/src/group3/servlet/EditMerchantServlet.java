package group3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group3.po.MerchantInfo;
import group3.service.UpdateMerchantsInfoService;
import group3.service.impl.UpdateMerchantsInfoServiceImpl;
import group3.util.ProjectConstant;

/**
 * Servlet implementation class EditMerchantServlet
 */
@WebServlet("/EditMerchant")
public class EditMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UpdateMerchantsInfoService ums =new UpdateMerchantsInfoServiceImpl();

    public EditMerchantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer merchantId=-1;
		
		HttpSession sen = request.getSession();
		
		
		
		try {
//			merchantId = Integer.parseInt(request.getParameter("merchantId"));
			if (sen.getAttribute(ProjectConstant.SESSION_ATTRIBUTE_USERID)!= null){
				merchantId = (int)sen.getAttribute(ProjectConstant.SESSION_ATTRIBUTE_USERID);
			}
		} catch (NumberFormatException e) {
			merchantId = -1;
		}
		
		MerchantInfo u= ums.findMerchantInfo(merchantId);
		request.setAttribute("u", u);
		request.getRequestDispatcher("UpdateMerchantForm.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
