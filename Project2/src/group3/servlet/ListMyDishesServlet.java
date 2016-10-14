package group3.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group3.dao.DishDao;
import group3.dao.impl.DishDaoImpl;
import group3.po.Dish;

/**
 * Servlet implementation class ListMyDishesServlet
 */
@WebServlet("/listMyDishes")
public class ListMyDishesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DishDao dd = new DishDaoImpl();
	
    public ListMyDishesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//int id = Integer.parseInt(request.getParameter("merchantId"));
		
		List<Dish> dishes = new ArrayList<Dish>();		
		dishes = dd.findAllDish();					
		request.setAttribute("dishes", dishes);
		request.getRequestDispatcher("myDishes.jsp").forward(request, response);	
	}
}
