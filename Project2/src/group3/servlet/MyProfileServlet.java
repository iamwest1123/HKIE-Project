package group3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group3.dao.MerchantInfoDao;
import group3.dao.impl.MerchantInfoDaoImpl;
import group3.po.MerchantInfo;
import group3.util.ProjectConstant;

/**
 * Servlet implementation class MerchantProfile
 */
@WebServlet("/myProfile")
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MerchantInfoDao md = new MerchantInfoDaoImpl();
       
    public MyProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sen = request.getSession();
		
		int merchantId = -1;
		
		if (sen.getAttribute(ProjectConstant.SESSION_ATTRIBUTE_USERID)!= null){
			merchantId = (int)sen.getAttribute(ProjectConstant.SESSION_ATTRIBUTE_USERID);
		}
		
		MerchantInfo m = md.findMerchantInfo(merchantId);
		request.setAttribute("m", m);
		
		request.getRequestDispatcher("merchantProfile.jsp").forward(request, response);
	}

}
