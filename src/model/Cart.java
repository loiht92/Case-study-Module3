package model;

public class Cart {
	private Integer id;
	private Integer userId;
	private Integer clothingId;
	private Integer quantity;
	
	public Cart(){}
	
	public Cart(Integer id, Integer userId, Integer clothingId, Integer quantity) {
		this.id = id;
		this.userId = userId;
		this.clothingId = clothingId;
		this.quantity = quantity;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
