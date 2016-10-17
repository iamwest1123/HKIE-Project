package group3.service;

public interface LoginService {
	public boolean Login(String username, String password, String userType);
	public String LoginFailReason(String username, String password, String userType);
	public Integer getUserId(String username, String password, String userType);
}
