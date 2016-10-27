package dao;

import java.util.List;

import po.AdminAdvert;

public interface AdminAdvertDao {

	public void addAdminAdv(AdminAdvert a);
	public List<AdminAdvert> findAllAdv();
	public void updateAdminAdv(AdminAdvert u);
	public void deleteAdminAdv(String id);
	public AdminAdvert loadAdminAdv(String id);
	
}
