package group3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group3.service.LoginService;
import group3.service.impl.LoginServiceImpl;
import group3.util.ProjectConstant;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginService loginService = new LoginServiceImpl();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		boolean isSuccess = loginService.Login(username, password, userType);
		if (!isSuccess) {
			String failReason = loginService.LoginFailReason(username, password, userType);
			request.setAttribute("isSuccess", false);
			request.setAttribute("failReason", failReason);
			request.setAttribute("userType", userType);
			request.getRequestDispatcher(ProjectConstant.UI_LOGIN_AS).forward(request, response);
		} else {
			sen.setAttribute(ProjectConstant.SESSION_ATTRIBUTE_USERNAME, username);
			sen.setAttribute(ProjectConstant.SESSION_ATTRIBUTE_USERTYPE, userType);
			// TODO send user to their page
		}
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
