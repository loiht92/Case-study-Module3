package service.Coupon;

import model.Category;
import model.Coupon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CouponServiceImpl implements ICoupon{
    private static final String  jdbcURL = "jdbc:mysql://localhost:3306/clothing_manager";
    private static final String jdbcUser = "root";
    private static final String jdbcPass = "loi123456";
    String selectCoupon = "select * from coupon";
    String insertCoupon = "insert into coupon (import_date) value (?)";
    String updateCoupon = "update coupon set import_date = ? where id = ?";
    String deleteCoupon = "delete from coupon where id = ?";

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
    public List<Coupon> findAll() {
            List<Coupon> coupons = new ArrayList<>();

            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(selectCoupon)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String import_date = resultSet.getString("import_date");

                    coupons.add(new Coupon(import_date));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return coupons;
    }

    @Override
    public void insert(Coupon coupon) throws SQLException {

    }

    @Override
    public boolean update(Coupon coupon) throws SQLException {
        return false;
    }

    @Override
    public boolean remove(int id) throws SQLException {
        return false;
    }
}
