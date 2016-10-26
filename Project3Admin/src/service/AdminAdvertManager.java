package service;

import java.util.List;

import po.AdminAdvert;

public interface AdminAdvertManager {
	
	public void addAdminAdv(AdminAdvert a);
	public void updateAdminAdv(AdminAdvert aa);
	public void deleteAdminAdv(String id);
	public AdminAdvert loadAdminAdv(String id);
	public List<AdminAdvert> findAllAdv();
	
}
