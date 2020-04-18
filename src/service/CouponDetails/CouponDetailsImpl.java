package service.CouponDetails;

import model.Category;
import model.CouponDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CouponDetailsImpl implements ICouponDetails{
    private static final String  jdbcURL = "jdbc:mysql://localhost:3306/clothing_manager";
    private static final String jdbcUser = "root";
    private static final String jdbcPass = "loi123456";
    String selectCouponDetails = "select * from coupon_details";
    String insertCouponDetails = "insert into coupon_details (number_of_import, import_price) value (?,?)";
    String updateCouponDetails = "update coupon_details set number_of_import = ?, import_price = ? where id = ?";
    String deleteCouponDetails = "delete from coupon_details where id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
        } catch (SQLException e) {
            System.out.println("Khong ket noi duoc");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public List<CouponDetails> findAll() {
        List<CouponDetails> couponDetails = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(selectCouponDetails)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int number_import = Integer.parseInt(resultSet.getString("number_of_import"));
                float import_price = Float.parseFloat(resultSet.getString("import_price"));

                couponDetails.add(new CouponDetails(number_import, import_price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return couponDetails;
    }

    @Override
    public void insert(CouponDetails couponDetails) throws SQLException {

    }

    @Override
    public boolean update(CouponDetails couponDetails) throws SQLException {
        return false;
    }

    @Override
    public boolean remove(int id) throws SQLException {
        return false;
    }
}
