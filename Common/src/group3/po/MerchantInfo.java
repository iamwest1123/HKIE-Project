package group3.po;

import java.sql.Date;

public class MerchantInfo {

	
	private Integer id;
	private String merchantName;
	private Integer age;
	private String gender;
	private Date registerTime;
	private String shopName;
	private String telNum;
	private String address;
	private String shopPicUrl;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
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
