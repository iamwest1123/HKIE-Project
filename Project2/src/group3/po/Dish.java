package group3.po;

public class Dish {

	int merchantId;
	int dishId;
	String name;
	String description;
	double price;
	String dishPicUrl;
	String isValid;
	double qty;
	
	
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDishPicUrl() {
		return dishPicUrl;
	}
	public void setDishPicUrl(String dishPicUrl) {
		this.dishPicUrl = dishPicUrl;
	}
	public String isValid() {
		return isValid;
	}
	public void setValid(String isValid) {
		this.isValid = isValid;
	}
	public double getQty() {
		return qty;
	}
	public void setQty(double qty) {
		this.qty = qty;
	}
	
	
}
