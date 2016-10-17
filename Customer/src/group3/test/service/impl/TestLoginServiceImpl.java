package group3.test.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import group3.service.LoginService;
import group3.service.impl.LoginServiceImpl;
import group3.util.ProjectConstant;

public class TestLoginServiceImpl {
	LoginService im = new LoginServiceImpl();
	
	@Test
	public void testLogin() {
		boolean isSuccess = im.Login("Ken", "", ProjectConstant.USERTYPE_MERCHENT);
		System.out.println(isSuccess);
	}

}
