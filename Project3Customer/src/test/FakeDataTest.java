package test;

import static org.junit.Assert.*;

import org.junit.Test;

import po.Merchant;
import util.ProjectConstant;

public class FakeDataTest {

	@Test
	public void test() {
		Merchant m = new Merchant();
		m.setMerchantName("Ryan Merchant Name");
		m.setShopName("Ryan Shop");
		m.setTelNum("22338583");
		m.setShopName("kobe.png");
		m.setPassword("iloveoocl");
		m.setLoginName("ryanbb");
		m.setStatus(ProjectConstant.STATUS_ACCEPTED);
		m.setCategory(ProjectConstant.CATEGORY_CHINESE);
		m.setOpeningHour(9);
		m.setClosingHour(23);
		m.setGender(false);
		m.setCanPreOrder(true);
		
		
		
	}

}
