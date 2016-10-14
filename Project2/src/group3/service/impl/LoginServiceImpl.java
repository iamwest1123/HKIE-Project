package group3.service.impl;

import group3.dao.MerchantInfoDao;
import group3.dao.MerchantStatusDao;
import group3.dao.impl.MerchantInfoDaoImpl;
import group3.dao.impl.MerchantStatusDaoImpl;
import group3.po.MerchantInfo;
import group3.po.MerchantStatus;
import group3.service.LoginService;
import group3.util.ProjectConstant;

public class LoginServiceImpl implements LoginService {
	private MerchantInfoDao mid= new MerchantInfoDaoImpl();
	private MerchantStatusDao msd= new MerchantStatusDaoImpl();

	@Override
	public boolean Login(String username, String password, String userType) {
		if (ProjectConstant.USERTYPE_MERCHENT.equals(userType)) {
			MerchantInfo mInfo = mid.findMerchantInfoByName(username);
			if (mInfo==null)
				return false;
			MerchantStatus mStatus = msd.findMerchantStatus(mInfo.getId());
			if (mStatus==null)
				return false;
			if (!ProjectConstant.MERCHANT_STATUS_ACCEPTED.equals(mStatus.getStatus()))
				return false;
			return true;
		}
		return true;
	}

	@Override
	public String LoginFailReason(String username, String password, String userType) {
		String reason = null;
		MerchantInfo mInfo = mid.findMerchantInfoByName(username);
		if (mInfo==null)
			reason = "User Name not found";
		else {
			MerchantStatus mStatus = msd.findMerchantStatus(mInfo.getId());
			if (mStatus==null)
				reason = "Internal data error. Please contact admin";
			else if (ProjectConstant.MERCHANT_STATUS_REJECTED.equals(mStatus.getStatus()))
				reason = "Your application has been rejected by admin";
			else if (ProjectConstant.MERCHANT_STATUS_UNDERREVIEW.equals(mStatus.getStatus()))
				reason = "Your application is pending for approval";
			else if (ProjectConstant.MERCHANT_STATUS_FORZEN.equals(mStatus.getStatus()))
				reason = "Your account has been frozen.";
			else 
				reason = "Merchant Status data error. please contact administrator.";
		}
		return reason;
	}

	@Override
	public Integer getUserId(String username, String password, String userType) {
		if (ProjectConstant.USERTYPE_MERCHENT.equals(userType)) {
			MerchantInfo mInfo = mid.findMerchantInfoByName(username);
			return mInfo.getId();
		}
		return null;
	}


}
