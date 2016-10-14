package group3.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group3.po.Dish;

/**
 * Servlet implementation class AddDishServlet
 */
@WebServlet("/addDish")
public class AddDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//DishDao dd = new DishDaoImpl();
	
    public AddDishServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dishName = request.getParameter("dishName");
		String description = request.getParameter("description");
		Double price = Double.parseDouble(request.getParameter("price"));
		String picture = request.getParameter("picture");
		Double qty = Double.parseDouble(request.getParameter("qty"));
		
		Dish d = new Dish();
		
		d.setDescription(description);
		d.setPrice(price);
		d.setQty(qty);
		
		//dd.addDish(d);
		
		response.sendRedirect("listMyDishes");
	}

}