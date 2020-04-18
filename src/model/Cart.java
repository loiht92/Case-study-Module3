package model;

public class Cart {
	private Integer cartId;
	private Integer userId;
	private Integer clothingId;
	private Integer quantity;
	
	public Integer getCartId() {
		return cartId;
	}
	
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getClothingId() {
		return clothingId;
	}
	
	public void setClothingId(Integer clothingId) {
		this.clothingId = clothingId;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
