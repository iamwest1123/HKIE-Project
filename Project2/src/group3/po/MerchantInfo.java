package group3.po;

import java.sql.Date;

public class MerchantInfo {

	
	int id;
	String merchantName;
	int age;
	String gender;
	Date registerTime;
	String shopName;
	String telNum;
	String address;
	String shopPicUrl;
	
	
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String name) {
		this.merchantName = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getShopPicUrl() {
		return shopPicUrl;
	}
	public void setShopPicUrl(String shopPicUrl) {
		this.shopPicUrl = shopPicUrl;
	}
	
	
	
}
