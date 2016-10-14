package group3.dao.impl;

import static org.junit.Assert.fail;

import org.junit.Test;

import group3.dao.MerchantStatusDao;
import group3.po.MerchantStatus;

public class MerchantStatusDaoImplTest {

	@Test
	public void testAddMerchantStatus() {
		
		MerchantStatusDao dao = new MerchantStatusDaoImpl();
		MerchantStatus ms = new MerchantStatus();
		ms.setId(5);
		ms.setStatus("1234");
		dao.addMerchantStatus(ms);
	}

	@Test
	public void testUpdateMerchantStatus() {
		MerchantStatusDao dao = new MerchantStatusDaoImpl();
		MerchantStatus ms = new MerchantStatus();
		ms.setId(2);
		ms.setStatus("444444");
		dao.updateMerchantStatus(ms);
	}

	@Test
	public void testDeleteMerchantStatus() {
		MerchantStatusDao dao = new MerchantStatusDaoImpl();
		dao.deleteMerchantStatus(2);
	}

	@Test
	public void testFindAllMerchantStatus() {
		MerchantStatusDao dao = new MerchantStatusDaoImpl();
		dao.findAllMerchantStatus();
	}
	
	@Test
	public void testFindMerchantStatus() {
		MerchantStatusDao dao = new MerchantStatusDaoImpl();
		dao.findMerchantStatus(2);
	}

}
