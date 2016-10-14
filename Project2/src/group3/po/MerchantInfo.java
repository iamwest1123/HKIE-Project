package group3.po;

import java.sql.Date;

public class MerchantInfo {

	
	int id;
	String name;
	int age;
	Date registerTime;
	String address;
	String shopPicUrl;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
