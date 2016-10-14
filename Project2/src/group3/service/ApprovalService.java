package group3.service;

import java.util.List;

import group3.po.MerchantInfo;

public interface ApprovalService {

	public List<MerchantInfo> findUnapprovalMerchants();
	
}
