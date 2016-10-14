package group3.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.management.j2ee.statistics.Statistic;
import javax.net.ssl.SSLEngineResult.Status;

import group3.dao.MerchantInfoDao;
import group3.dao.MerchantStatusDao;
import group3.dao.impl.MerchantInfoDaoImpl;
import group3.dao.impl.MerchantStatusDaoImpl;
import group3.po.MerchantInfo;
import group3.po.MerchantStatus;
import group3.service.ApprovalService;
import group3.util.ProjectConstant;
import oracle.net.aso.MD5;

public class ApprovalServiceImpl implements ApprovalService {

	private MerchantStatusDao merchantStatusDao = new MerchantStatusDaoImpl();
	private MerchantInfoDao merchantInfoDao = new MerchantInfoDaoImpl();
	
	@Override
	public List<MerchantInfo> findUnapprovalMerchants() {
		List<MerchantInfo> result = new ArrayList<MerchantInfo>();	
		List<MerchantInfo> merchantInfosList = merchantInfoDao.findAllMerchantInfo();
		List<MerchantStatus> merchantStatusList = merchantStatusDao.findAllMerchantStatus();
		for (MerchantInfo info:merchantInfosList) {
			int infoId = info.getId();
			for (MerchantStatus status:merchantStatusList) 
				if (status.getId() == infoId && status.getStatus().equals(ProjectConstant.MERCHANT_STATUS_UNDERREVIEW)) {
					result.add(info);
					break;
				}
		}
		return result;
	}
	
}
