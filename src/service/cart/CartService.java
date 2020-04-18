package service.cart;

import model.Cart;
import service.DatabaseInit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartService extends DatabaseInit {
	
	public void add(Cart cart) throws SQLException {
		String insertItem= "insert into cart (id, user_id, clothing_id, quantity) values (?,?,?,?)";
		
		try(
				Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(insertItem)
		) {
			statement.setInt(1, cart.getId());
			statement.setInt(2, cart.getUserId());
			statement.setInt(3, cart.getClothingId());
			statement.setInt(4, cart.getQuantity());
			System.out.println(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
