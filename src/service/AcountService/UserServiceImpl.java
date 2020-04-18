package service.AcountService;

import model.User;

import java.sql.*;

public class UserServiceImpl implements IUserService {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/clothing_manager";
    private static final String jdbcUser = "root";
    private static final String jdbcPass = "loi123456";


    protected static Connection getConnection() {
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
    public User findUser(String email, String pass) throws SQLException {
        String SELECT_USER = "select name from clothing_manager.user where email = ? and pass_word = ?;";
        User user = null;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_USER)) {

             statement.setString(1, email);
             statement.setString(2, pass);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                user = new User(name);
            }

        }
        return user;
    }
}

