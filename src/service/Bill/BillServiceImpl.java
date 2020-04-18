package service.Bill;

import model.Bill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillServiceImpl implements IBill{
    private static final String  jdbcURL = "jdbc:mysql://localhost:3306/clothing_manager";
    private static final String jdbcUser = "root";
    private static final String jdbcPass = "loi123456";
    String selectBill = "select * from bill";
    String insertBill = "insert into bill (export_date, customer_name) value (?,?)";
    String updateBill = "update bill set export_date = ?, customer_name = ? where id = ?";
    String deleteBill = "delete from bill where id = ?";

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
    public List<Bill> findAll() {
        List<Bill> bills = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(selectBill)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String export_date = resultSet.getString("export_date");
                String customer_name = resultSet.getString("customer_name");

                bills.add(new Bill(export_date,customer_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bills;
    }

    @Override
    public void insert(Bill bill) throws SQLException {
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(insertBill))
        {
            statement.setString(1, bill.getExport_date());
            statement.setString(2,bill.getCustomer_name());
            System.out.println(statement);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean update(Bill bill) throws SQLException {
        boolean rowUpdated;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(updateBill)) {
            statement.setString(1, bill.getExport_date());
            statement.setString(2,bill.getCustomer_name());
            statement.setInt(3,bill.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean remove(int id) throws SQLException {
        boolean rowDeleted;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(deleteBill)) {
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
