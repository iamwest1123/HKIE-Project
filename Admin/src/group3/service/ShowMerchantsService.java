package group3.service;

import java.util.List;

import group3.po.MerchantInfo;

public interface ShowMerchantsService {

	public List<MerchantInfo> showMerchants();
	public List<MerchantInfo> showAcceptedMerchants();
}
