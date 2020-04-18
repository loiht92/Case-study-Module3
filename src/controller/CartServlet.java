package controller;

import model.Cart;
import model.Category;
import service.cart.CartService;
import service.category.CategoryServiceImpl;
import service.category.ICategoryService;
import service.clothing.ClothingServiceImpl;
import service.clothing.IClothingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet {
	
	private final CartService cartService = new CartService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String action = request.getParameter("action");
		
		try {
			switch (action != null ? action : "") {
				case "add":
					add(request, response);
					break;
				case "delete":
					delete(request, response);
					break;
				case "list":
					list(request, response);
					break;
				default:
					break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException,
			IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer clothingId = Integer.valueOf(request.getParameter("clothingId"));
		Integer quantity = Integer.valueOf(request.getParameter("quantity"));
		
		Cart cart = new Cart(id, userId, clothingId, quantity);
		this.cartService.add(cart);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart/list.jsp");
		requestDispatcher.forward(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) {
	
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) {
	
	}
}
