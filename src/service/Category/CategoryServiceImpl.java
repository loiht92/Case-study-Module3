package service.Category;

import model.Category;
import model.Clothing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private static final String  jdbcURL = "jdbc:mysql://localhost:3306/clothing_manager";
    private static final String jdbcUser = "root";
    private static final String jdbcPass = "loi123456";
    String selectCategory = "select * from category";
    String insertCategory= "insert into clothing_manager.category (category_name, status) value (?,?)";
    String updateCategory = "update clothing_manager.category set category_name = ?, status = ? where category_id = ?";
    String deleteCategory = "delete from clothing_manager.category where category_id = ?";

    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUser,jdbcPass);
        } catch (SQLException e) {
            System.out.println("Khong ket noi duoc");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        String selectAllCategory = "SELECT * FROM clothing_manager.category ";

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(selectAllCategory)
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("category_id");
                String name = resultSet.getString("category_name");
                String status = resultSet.getString("status");

                categories.add(new Category(id, name, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void insert(Category category) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(insertCategory)) {
            statement.setString(1, category.getName());
            statement.setString(2,category.getStatus());
            System.out.println(statement);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean update(Category category) throws SQLException {
        boolean rowUpdated;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(updateCategory)) {
            statement.setString(1, category.getName());
            statement.setString(2,category.getStatus());
            statement.setInt(3,category.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean remove(int id) throws SQLException {
        boolean rowDeleted;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(deleteCategory)) {
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Category> findByCategoryName(String name) throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from category where category_name = ?");) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String status = resultSet.getString(2);

                Category category = new Category(id, name, status);
                categoryList.add(category);
            }
        }
        return categoryList;
    }
}
