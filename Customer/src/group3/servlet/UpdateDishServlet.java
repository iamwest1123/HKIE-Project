package group3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group3.dao.DishDao;
import group3.dao.impl.DishDaoImpl;
import group3.po.Dish;

/**
 * Servlet implementation class EditDishServlet
 */
@WebServlet("/updateDish")
public class UpdateDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DishDao dd = new DishDaoImpl(); 

    public UpdateDishServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer merchantId;
		try {
			merchantId = Integer.parseInt(request.getParameter("merchantId"));
		} catch (NumberFormatException e) {
			merchantId = -1;
		}
		
		Integer dishId;
		try {
			dishId = Integer.parseInt(request.getParameter("dishId"));
		} catch (NumberFormatException e) {
			dishId = -1;
		}
		
		String dishName = request.getParameter("dishName");
		String description = request.getParameter("description");
		
		Double price;
		
		try {
			price = Double.parseDouble(request.getParameter("price"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			price = 0.0;
		}	
		
		Double qty;
		try {
			qty = Double.parseDouble(request.getParameter("qty"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			qty = 0.0;
		}
		
		Dish d = new Dish();				
		d.setDescription(description);
		d.setDishPicUrl("");
		d.setMerchantId(merchantId);
		d.setDishId(dishId);
		d.setName(dishName);
		d.setQty(qty);		
		d.setValid("T");
		d.setPrice(price);		
		dd.updateDish(d);
		
		response.sendRedirect("listMyDishes");
	}
}
