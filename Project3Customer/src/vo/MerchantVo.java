package vo;

import java.util.ArrayList;
import java.util.List;

import po.Address;
import po.Comment;
import po.Dish;
import po.Merchant;

public class MerchantVo {
	private String id;
	private String merchantName;
	private String shopName;
	private String telNum;
	private String shopPic;
	private String status;
	private String category;
	private Integer openingHour;
	private Integer closingHour;
	private Boolean canPreOrder;
	private Boolean gender;
	
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	private Address address;
	private List<Dish> dishList = new ArrayList<Dish>();
	
	public MerchantVo() {
		
	}
	public MerchantVo(Merchant m) {
		this.setId(m.getId());
		this.setMerchantName(m.getMerchantName());
		this.setShopName(m.getShopName());
		this.setTelNum(m.getTelNum());
		this.setShopPic(m.getShopPic());
		this.setStatus(m.getStatus());
		this.setCategory(m.getCategory());
		this.setOpeningHour(m.getOpeningHour());
		this.setClosingHour(m.getClosingHour());
		this.setCanPreOrder(m.getCanPreOrder());
		this.setGender(m.getGender());
		this.setAddress(m.getAddress());
		this.setDishList(m.getDishList());
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public String getShopPic() {
		return shopPic;
	}
	public void setShopPic(String shopPic) {
		this.shopPic = shopPic;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getOpeningHour() {
		return openingHour;
	}
	public void setOpeningHour(Integer openingHour) {
		this.openingHour = openingHour;
	}
	public Integer getClosingHour() {
		return closingHour;
	}
	public void setClosingHour(Integer closingHour) {
		this.closingHour = closingHour;
	}
	public Boolean getCanPreOrder() {
		return canPreOrder;
	}
	public void setCanPreOrder(Boolean canPreOrder) {
		this.canPreOrder = canPreOrder;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Dish> getDishList() {
		return dishList;
	}
	public void setDishList(List<Dish> dishList) {
		this.dishList = dishList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((canPreOrder == null) ? 0 : canPreOrder.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((closingHour == null) ? 0 : closingHour.hashCode());
		result = prime * result + ((dishList == null) ? 0 : dishList.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((merchantName == null) ? 0 : merchantName.hashCode());
		result = prime * result + ((openingHour == null) ? 0 : openingHour.hashCode());
		result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
		result = prime * result + ((shopPic == null) ? 0 : shopPic.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((telNum == null) ? 0 : telNum.hashCode());
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
		MerchantVo other = (MerchantVo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (canPreOrder == null) {
			if (other.canPreOrder != null)
				return false;
		} else if (!canPreOrder.equals(other.canPreOrder))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (closingHour == null) {
			if (other.closingHour != null)
				return false;
		} else if (!closingHour.equals(other.closingHour))
			return false;
		if (dishList == null) {
			if (other.dishList != null)
				return false;
		} else if (!dishList.equals(other.dishList))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (merchantName == null) {
			if (other.merchantName != null)
				return false;
		} else if (!merchantName.equals(other.merchantName))
			return false;
		if (openingHour == null) {
			if (other.openingHour != null)
				return false;
		} else if (!openingHour.equals(other.openingHour))
			return false;
		if (shopName == null) {
			if (other.shopName != null)
				return false;
		} else if (!shopName.equals(other.shopName))
			return false;
		if (shopPic == null) {
			if (other.shopPic != null)
				return false;
		} else if (!shopPic.equals(other.shopPic))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (telNum == null) {
			if (other.telNum != null)
				return false;
		} else if (!telNum.equals(other.telNum))
			return false;
		return true;
	}
}
