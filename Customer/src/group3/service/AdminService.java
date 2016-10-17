package group3.service;

import java.util.LinkedHashMap;
import java.util.List;

import group3.po.MerchantInfo;
import group3.po.MerchantStatus;

public interface AdminService {

	public List<MerchantInfo> findUnapprovalMerchants();
	public LinkedHashMap<MerchantInfo,MerchantStatus> findAllMerchant();
}
