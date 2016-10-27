package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import util.ProjectConstant;
import vo.MerchantVo;

@Controller
@RequestMapping(value="session")
public class SessionController {
	
	@RequestMapping(value="getMerchantVo")
	@ResponseBody
	public MerchantVo getMerchantVo() {
		return null;
	}
	
	@RequestMapping(value="setMerchantVo")
	@ResponseBody
	public boolean setMerchantVo() {
		return false;
	}
	
	@RequestMapping(value="getMerchantId")
	@ResponseBody
	public String getMerchantId(HttpSession session) {
		Object obj = session.getAttribute(ProjectConstant.SESSION_ATTRIBUTE_MERCHANT_ID);
		if (obj==null)
			return "";
		else
			return (String) obj;
	}
	
	@RequestMapping(value="setMerchantId")
	@ResponseBody
	public boolean setMerchantId(String merchantId, HttpSession session) {
		session.setAttribute(ProjectConstant.SESSION_ATTRIBUTE_MERCHANT_ID, merchantId);
		return true;
	}
	
	@RequestMapping(value="getCustomerVo")
	@ResponseBody
	public MerchantVo getCustomerVo() {
		return null;
	}
	
	@RequestMapping(value="setCustomerVo")
	@ResponseBody
	public boolean setCustomerVo() {
		return false;
	}
}
