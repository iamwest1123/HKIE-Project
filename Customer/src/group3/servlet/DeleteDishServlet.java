package group3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group3.dao.DishDao;
import group3.dao.impl.DishDaoImpl;

/**
 * Servlet implementation class DeleteDishes
 */
@WebServlet("/deleteDish")
public class DeleteDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DishDao dd = new DishDaoImpl();

    public DeleteDishServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int dishId = -1;
    	
    	if (request.getParameter("dishId")!=""){
    		dishId = Integer.parseInt(request.getParameter("dishId"));
    	}
    	
		dd.deleteDish(dishId);
		response.sendRedirect("listMyDishes");
	}

}
