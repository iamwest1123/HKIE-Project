package vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCart {
	private List<ShoppingItem> shoppingItems = new ArrayList<ShoppingItem>();
	private String addressId;

	public List<ShoppingItem> getShoppingItems() {
		return shoppingItems;
	}
	public void setShoppingItems(List<ShoppingItem> shoppingItems) {
		this.shoppingItems = shoppingItems;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
}
