package group3.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group3.dao.DishDao;
import group3.dao.impl.DishDaoImpl;
import group3.po.Dish;
import group3.util.ProjectConstant;

/**
 * Servlet implementation class CustomerListDishesServlet
 */
@WebServlet("/customerListDishes")
public class CustomerListDishesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DishDao dd = new DishDaoImpl();
	
    public CustomerListDishesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int merchantId;
		
		try {
			merchantId = Integer.parseInt(request.getParameter("merchantId"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			merchantId = -1;
		}
		
		List<Dish> dishes = new ArrayList<Dish>();		
		dishes = dd.findMerchantDish(merchantId);					
		request.setAttribute("dishes", dishes);
		request.getRequestDispatcher("customerListDishes.jsp").forward(request, response);	
	}

}
