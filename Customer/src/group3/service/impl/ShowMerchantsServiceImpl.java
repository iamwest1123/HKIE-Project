package group3.service.impl;

import java.util.ArrayList;
import java.util.List;

import group3.dao.MerchantInfoDao;
import group3.dao.MerchantStatusDao;
import group3.dao.impl.MerchantInfoDaoImpl;
import group3.dao.impl.MerchantStatusDaoImpl;
import group3.po.MerchantInfo;
import group3.po.MerchantStatus;
import group3.service.ShowMerchantsService;
import group3.util.*;
import oracle.net.aso.MD5;

public class ShowMerchantsServiceImpl implements ShowMerchantsService {

	MerchantInfoDao md = new MerchantInfoDaoImpl();
	MerchantStatusDao ms =new MerchantStatusDaoImpl();
	@Override
	public List<MerchantInfo> showMerchants() {
		return md.findAllMerchantInfo();
	}
	@Override
	public List<MerchantInfo> showAcceptedMerchants() {
		// TODO Auto-generated method stub
		List<MerchantInfo> allMerchantInfos = md.findAllMerchantInfo();
		List<MerchantInfo> acceptedMerchantInfos =new ArrayList<MerchantInfo>();
		List<MerchantStatus> allStatus = ms.findAllMerchantStatus();
		for(MerchantInfo m: allMerchantInfos){
		
			for(MerchantStatus s:allStatus){
				if((m.getId()==s.getId())&&(s.getStatus().equals(ProjectConstant.MERCHANT_STATUS_ACCEPTED))){
				acceptedMerchantInfos.add(m);
				}
			}
		}
		return acceptedMerchantInfos;
	}

}
