package controller;

import model.Category;
import model.Clothing;
import service.Category.CategoryServiceImpl;
import service.Clothing.ClothingServiceImpl;
import service.Category.ICategoryService;
import service.Clothing.IClothingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ClothingServlet", urlPatterns = "/clothing")
public class ClothingServlet extends HttpServlet {
    private IClothingService clothingService = new ClothingServiceImpl();
    private ICategoryService categoryService = new CategoryServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action != null ? action : "") {
                case "createClothing":
                    createClothing(request, response);
                    break;
                case "update":
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
                case "createClothing":
                    showCreateClothing(request, response);
                    break;
                case "editClothing":
                    showEditClothing(request, response);
                    break;
                case "listClothing":
                    showListClothing(request,response);
                    break;
                case "deleteClothing":
                    deleteClothing(request, response);
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

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clothes/list_clothing_category.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showListClothing(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
        List<Clothing> clothing = this.clothingService.findAllClothingCategory();
        request.setAttribute("clothing", clothing);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clothes/list_clothing_category.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showListCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
        List<Category> categories = this.categoryService.findAll();
        request.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clothes/list_category.jsp");
        requestDispatcher.forward(request,response);

    }

    private void createClothing(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        String name = request.getParameter("clothing.name");
        String description = request.getParameter("clothing.description");
        String picture = request.getParameter("clothing.picture");
        int price = Integer.parseInt(request.getParameter("clothing.price"));
        String origin = request.getParameter("clothing.origin");

        String categoryName = request.getParameter("category.name");
        String categoryStatus = request.getParameter("category.status");

        List<Category> categoryList = this.categoryService.findAll();
        request.setAttribute("listCategory", categoryList);

        Clothing clothing = new Clothing(name,description,picture,price,origin,categoryName,categoryStatus);
        this.clothingService.insert(clothing);

//        Category category = new Category(categoryName, categoryStatus);
//        this.categoryService.insert(category);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clothes/create_clothing.jsp");
        request.setAttribute("message","Tao moi thanh cong");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String status = request.getParameter("status");
        Category category = new Category(name,status);
        this.categoryService.insert(category);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clothes/create_category.jsp");
        requestDispatcher.forward(request,response);

    }

    private void showCreateClothing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clothes/create_clothing.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showCreateCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clothes/create_category.jsp");
        requestDispatcher.forward(request,response);
    }

    private void editClothing(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String picture = request.getParameter("picture");
        int price = Integer.parseInt(request.getParameter("price"));
        String origin = request.getParameter("origin");

        Clothing clothing = new Clothing(id,name,description,picture,price,origin);
        this.clothingService.update(clothing);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clothes/edit_clothing.jsp");
        requestDispatcher.forward(request,response);
    }

    private void editCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String status = request.getParameter("status");

        Category category = new Category(id,name,status);
        this.categoryService.update(category);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clothes/edit_category.jsp");
        requestDispatcher.forward(request,response);

    }

    private void showEditClothing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clothes/edit_clothing.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showEditCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clothes/edit_category.jsp");
        requestDispatcher.forward(request,response);
    }

    private void deleteClothing(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.clothingService.remove(id);
        List<Clothing> clothing  = this.clothingService.findAll();
        request.setAttribute("clothing",clothing);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clothes/list_clothing.jsp");
        requestDispatcher.forward(request,response);
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.categoryService.remove(id);
        List<Category> categories = this.categoryService.findAll();
        request.setAttribute("categories",categories);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clothes/list_category.jsp");
        requestDispatcher.forward(request,response);
    }
}
