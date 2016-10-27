package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MerchantDao;
import po.Comment;
import po.Merchant;
import service.MerchantManager;
import vo.MerchantVo;

@Service
public class MerchantManagerImpl implements MerchantManager{

	@Autowired
	private MerchantDao md;
	
	@Override
	@Transactional
	public List<MerchantVo> findAll() {
		
		List<Merchant> ms =  md.findAllMerchant();		
		List<MerchantVo> ms1= new ArrayList<MerchantVo>();
			
		for(Merchant m:ms){
			
			Merchant m1=new Merchant();
			
			try {
				BeanUtils.getProperty(m, "commentList");					
				
				for (Comment cm : m.getCommentList()){					
					BeanUtils.getProperty(cm.getCustomer(), "addressList");			
					BeanUtils.getProperty(cm.getCustomer(), "customerOrderList");					
				}
				
				BeanUtils.getProperty(m, "dishList");
				BeanUtils.getProperty(m, "customerOrderList");
				
				BeanUtils.copyProperties(m1, m);
				
				MerchantVo mvo = new MerchantVo(m1);
				ms1.add(mvo);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();							
			}				
		}
		return ms1;
	}

	@Override
	@Transactional
	public void registMerchant(Merchant m) {
		
		md.addMerchant(m);
		
	}

	@Override
	@Transactional
	public void updateMerchant(Merchant m) {
		
		md.updateMerchantInfo(m);
	}
	
	@Override
	@Transactional
	public void updateMerchantStatus(Merchant m) {
		md.updateMerchantStatus(m);
		
	}

	@Override
	@Transactional
	public void deleteMerchant(String id) {
		
		md.deleteMerchant(id);
	}

	@Override
	@Transactional
	public MerchantVo loadMerchant(String id) {
		Merchant m = md.loadMerchant(id);
		Merchant m1=new Merchant();
		MerchantVo mvo = null;
		
		try {
			BeanUtils.getProperty(m, "commentList");					
			
			for (Comment cm : m.getCommentList()){					
				BeanUtils.getProperty(cm.getCustomer(), "addressList");			
				BeanUtils.getProperty(cm.getCustomer(), "customerOrderList");					
			}
			
			BeanUtils.getProperty(m, "dishList");
			BeanUtils.getProperty(m, "customerOrderList");
			
			BeanUtils.copyProperties(m1, m);
			
			mvo = new MerchantVo(m1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();							
		}				
		
		return mvo;
	}

	@Override
	@Transactional
	public Merchant loadMerchant1(String id) {
		return md.loadMerchant(id);
	}

	@Override
	@Transactional
	public boolean isExist(Merchant m) {
		return md.isExist(m);
	}

	@Override
	@Transactional
	public Merchant findAdminByUsernameAndPassword(Merchant m) {
		return md.findAdminByUsernameAndPassword(m);
	}


}
