package controller;

import model.Clothing;
import model.Coupon;
import model.CouponDetails;
import service.Clothing.ClothingServiceImpl;
import service.Clothing.IClothingService;
import service.Coupon.CouponServiceImpl;
import service.Coupon.ICoupon;
import service.CouponDetails.CouponDetailsImpl;
import service.CouponDetails.ICouponDetails;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CouponDetailsServlet", urlPatterns = "/couponDetails")
public class CouponDetailsServlet extends HttpServlet {
    private IClothingService clothingService = new ClothingServiceImpl();
    private ICouponDetails couponDetails = new CouponDetailsImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action != null ? action : "") {
                case "createCouponDetails":
                    createCouponDetails(request, response);
                    break;
                case "updateCouponDetails":
                    editCouponDetails(request,response);
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
                case "createCouponDetails":
                    showCreateCouponDetails(request, response);
                    break;
                case "editCouponDetails":
                    showEditCouponDetails(request, response);
                    break;
                case "listCouponDetails":
                    showListCouponDetails(request,response);
                    break;
                case "deleteCouponDetails":
                    deleteCouponDetails(request, response);
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

    private void showListCouponDetails(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
        List<CouponDetails> couponDetails = this.couponDetails.findAll();
        request.setAttribute("couponDetails", couponDetails);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCouponDetails/list_coupon_details.jsp");
        requestDispatcher.forward(request,response);

    }

    private void createCouponDetails(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int number_import = Integer.parseInt(request.getParameter("number_import"));
        float import_price = Float.parseFloat(request.getParameter("import_price"));

        CouponDetails couponDetails = new CouponDetails(number_import,import_price);
        this.couponDetails.insert(couponDetails);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCouponDetails/create_coupon_details.jsp");
        requestDispatcher.forward(request,response);

    }


    private void showCreateCouponDetails(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCouponDetails/create_coupon_details.jsp");
        requestDispatcher.forward(request,response);
    }


    private void editCouponDetails(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int number_import = Integer.parseInt(request.getParameter("number_import"));
        float import_price = Float.parseFloat(request.getParameter("import_price"));


        CouponDetails couponDetails = new CouponDetails(id, number_import, import_price);
        this.couponDetails.update(couponDetails);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCoupon/edit_coupon.jsp");
        requestDispatcher.forward(request,response);

    }


    private void showEditCouponDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCoupon/edit_coupon.jsp");
        requestDispatcher.forward(request,response);
    }

    private void deleteCouponDetails(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.coupon.remove(id);
        List<Coupon> coupons = this.coupon.findAll();
        request.setAttribute("coupons",coupons);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listCoupon/list_coupon.jsp");
        requestDispatcher.forward(request,response);
    }
}
