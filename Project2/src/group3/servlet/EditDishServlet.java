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
@WebServlet("/editDish")
public class EditDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DishDao dd = new DishDaoImpl();

    public EditDishServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	this.doPost(req, resp);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dishId;
		
		try {
			dishId = Integer.parseInt(request.getParameter("dishId"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			dishId = -1;
		}
		
		Dish d = dd.loadDish(dishId);
		request.setAttribute("d", d);
		request.getRequestDispatcher("editDish.jsp").forward(request, response);		
	}

}
