package controller;

import model.Category;
import model.Clothing;
import model.Coupon;
import service.Category.CategoryServiceImpl;
import service.Category.ICategoryService;
import service.Clothing.ClothingServiceImpl;
import service.Clothing.IClothingService;
import service.Coupon.CouponServiceImpl;
import service.Coupon.ICoupon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CouponServlet", urlPatterns = "/coupon")
public class CouponServlet extends HttpServlet {
    private IClothingService clothingService = new ClothingServiceImpl();
    private ICoupon coupon = new CouponServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action != null ? action : "") {
                case "createCoupon":
                    createCoupon(request, response);
                    break;
                case "updateCoupon":
                    editCoupon(request,response);
                    break;
                default:
                    break;

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action != null ? action : "") {
                case "createCoupon":
                    showCreateCoupon(request, response);
                    break;
                case "editCoupon":
                    showEditCoupon(request, response);
                    break;
                case "listCoupon":
                    showListCoupon(request,response);
                    break;
                case "deleteCoupon":
                    deleteCoupon(request, response);
                    break;
                default:
                    listClothingCategory(request, response);
                    break;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    private void listClothingCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Clothing> clothing = this.clothingService.findAllClothingCategory();
        request.setAttribute("clothing", clothing);
//        List<Category> categories = this.categoryService.findAll();
//        request.setAttribute("categories",categories);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listHome/list_clothing_category.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showListCoupon(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
        List<Coupon> coupons = this.coupon.findAll();
        request.setAttribute("coupons", coupons);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCoupon/list_coupon.jsp");
        requestDispatcher.forward(request,response);

    }

    private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String import_date = request.getParameter("import_date");

        Coupon coupon = new Coupon(import_date);
        this.coupon.insert(coupon);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCoupon/create_coupon.jsp");
        requestDispatcher.forward(request,response);

    }


    private void showCreateCoupon(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCoupon/create_coupon.jsp");
        requestDispatcher.forward(request,response);
    }


    private void editCoupon(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String import_date = request.getParameter("import_date");


        Coupon coupon = new Coupon(id,import_date);
        this.coupon.update(coupon);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCoupon/edit_coupon.jsp");
        requestDispatcher.forward(request,response);

    }


    private void showEditCoupon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCoupon/edit_coupon.jsp");
        requestDispatcher.forward(request,response);
    }

    private void deleteCoupon(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.coupon.remove(id);
        List<Coupon> coupons = this.coupon.findAll();
        request.setAttribute("coupons",coupons);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCoupon/list_coupon.jsp");
        requestDispatcher.forward(request,response);
    }
}
