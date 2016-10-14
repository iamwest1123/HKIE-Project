package group3.test.dao.imple;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import group3.dao.MerchantInfoDao;
import group3.dao.impl.MerchantInfoDaoImpl;
import group3.po.MerchantInfo;

public class TestMerchantInfoDao {

	private MerchantInfoDao md = new MerchantInfoDaoImpl();
	
	@Test
	public void testAdd() {
		MerchantInfo m = new MerchantInfo();
		m.setAddress("test address 1234");
		m.setAge(99);
		m.setGender("M");
		m.setMerchantName("Sunny");
		m.setRegisterTime(new java.sql.Date(new java.util.Date().getTime()));
		m.setShopName("Sunny troll");
		m.setShopPicUrl("blow.jpg");
		m.setTelNum("94135354689");
		md.addMerchantInfo(m);
	}
	
	@Test
	public void testUpdate() {
		MerchantInfo m = md.findMerchantInfo(2);
		m.setTelNum("99");
		md.updateMerchantInfo(m);
		MerchantInfo m1 = md.findMerchantInfo(2);
		Assert.assertTrue(m1.getTelNum().equals("99"));
	}

	@Test
	public void testDelete() {
		md.deleteMerchantInfo(3);
	}
	
	@Test
	public void testFindOne() {
		MerchantInfo m = md.findMerchantInfo(2);
		MerchantInfo m1 = md.findMerchantInfo(3);
		Assert.assertTrue(m!=null);
		Assert.assertTrue(m1==null);
	}
	
	@Test
	public void testFindAll() {
		List<MerchantInfo> ms = md.findAllMerchantInfo();
		for(MerchantInfo m:ms) {
			System.out.print(m.getId()+"..."+m.getMerchantName()+"..."+m.getShopName());
		}
	}
	
}
