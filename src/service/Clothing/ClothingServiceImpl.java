package service.Clothing;

import model.Clothing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClothingServiceImpl implements IClothingService {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/clothing_manager";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "loi123456";

    String updateClothing = "update clothing_manager.clothing set name = ?, description = ?, picture = ?, price = ?, origin = ? where id = ?";
    String deleteClothing = "delete from clothing_manager.clothing where id = ?";

    public ClothingServiceImpl(){
    }
    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        } catch (SQLException e) {
            System.out.println("Khong ket noi duoc");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public List<Clothing> findAll() {
        List<Clothing> clothing = new ArrayList<>();
        String selectAllClothing = "SELECT * FROM clothing_manager.clothing ";

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(selectAllClothing)
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String picture = resultSet.getString("picture");
                int price = resultSet.getInt("price");
                String origin = resultSet.getString("origin");

                clothing.add(new Clothing(id, name, description, picture, price, origin));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clothing;
    }
    @Override//TODO Hiển thị danh sách thông tin của cả 2 bảng
    public List<Clothing> findAllClothingCategory() {
        List<Clothing> clothingCategory = new ArrayList<>();
        String selectAll = "SELECT cl.id, ca.category_name, ca.status, cl.name, cl.description, cl.picture, cl.price, cl.origin\n" +
                "FROM clothing_manager.category as ca INNER JOIN clothing_manager.clothing cl on cl.category_id = ca.category_id;";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(selectAll)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String picture = resultSet.getString("picture");
                int price = resultSet.getInt("price");
                String origin = resultSet.getString("origin");
                String category = resultSet.getString("category_name");
                String status = resultSet.getString("status");

                clothingCategory.add(new Clothing(name, description, picture, price, origin,category,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clothingCategory;
    }

    @Override
    public void insert(Clothing clothing) throws SQLException {
        String insertClothing = "insert into clothing_manager.clothing (name, description, picture, price, origin ) value (?,?,?,?,?)";

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(insertClothing)
        ) {

            statement.setString(1, clothing.getName());
            statement.setString(2, clothing.getDescription());
            statement.setString(3, clothing.getPicture());
            statement.setInt(4, clothing.getPrice());
            statement.setString(5, clothing.getOrigin());

            System.out.println(statement);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public List<Clothing> findByCategoryID(int id) {
//        List<Clothing> clothingList = new ArrayList<>();
//
//    }

    @Override
    public boolean update(Clothing clothing) throws SQLException {
        boolean rowUpdated;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(updateClothing)
        ) {

                statement.setString(1, clothing.getName());
                statement.setString(2,clothing.getDescription());
                statement.setString(3,clothing.getPicture());
                statement.setInt(4,clothing.getPrice());
                statement.setString(5,clothing.getOrigin());
                statement.setInt(6,clothing.getId());

                rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean remove(int id) throws SQLException {
        boolean rowDeleted;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(deleteClothing)
        ) {
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Clothing> findByPrice(int price) throws SQLException {
        List<Clothing> clothingList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from clothing_manager.clothing where price = ?");) {
            statement.setInt(1, price);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                String picture = resultSet.getString(4);
                String origin = resultSet.getString(5);

                Clothing clothing = new Clothing(id, name, description, picture, price, origin);
                clothingList.add(clothing);
            }
        }
        return clothingList;
    }

    @Override
    public List<Clothing> findByStatus(String status) {
        List<Clothing> clothingList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("select clothing_manager.clothing.id, clothing_manager.clothing.name, clothing_manager.clothing.description, clothing_manager.clothing.picture, clothing_manager.clothing.price,\n" +
                     "       clothing_manager.clothing.origin, c.category_name, c.status from clothing_manager.clothing inner join clothing_manager.category c on clothing_manager.clothing.category_id = c.category_id\n" +
                     "where status = ?;");) {
            statement.setString(1, status);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                String picture = resultSet.getString(4);
                int price = resultSet.getInt(5);
                String origin = resultSet.getString(6);
                String category_name = resultSet.getString(7);

                Clothing clothing = new Clothing(id, name, description, picture, price, origin, category_name,status);
                clothingList.add(clothing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clothingList;
    }
}
