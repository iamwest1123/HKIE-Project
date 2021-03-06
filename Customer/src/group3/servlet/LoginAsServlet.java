package group3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group3.util.ProjectConstant;

/**
 * Servlet implementation class LoginUserTypeServlet
 */
@WebServlet("/loginAs")
public class LoginAsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("userType", request.getParameter("userType"));
		if (request.getParameter("isSuccess")!=null)
			request.setAttribute("isSuccess", request.getParameter("isSuccess"));
		if (request.getParameter("failReason")!=null)
			request.setAttribute("failReason", request.getParameter("failReason"));
		request.getRequestDispatcher(ProjectConstant.UI_LOGIN_AS).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
