package vo;

import po.Dish;

public class ShoppingItem {
	private String dishId;
	private String dishName;
	private double dishPrice;
	private Integer quantity;
	public String getDishId() {
		return dishId;
	}
	public void setDishId(String dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public double getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(double dishPrice) {
		this.dishPrice = dishPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dishId == null) ? 0 : dishId.hashCode());
		result = prime * result + ((dishName == null) ? 0 : dishName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(dishPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingItem other = (ShoppingItem) obj;
		if (dishId == null) {
			if (other.dishId != null)
				return false;
		} else if (!dishId.equals(other.dishId))
			return false;
		if (dishName == null) {
			if (other.dishName != null)
				return false;
		} else if (!dishName.equals(other.dishName))
			return false;
		if (Double.doubleToLongBits(dishPrice) != Double.doubleToLongBits(other.dishPrice))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
}
