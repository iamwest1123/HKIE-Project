package mq.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.AdminAdvertDao;
import dto.AdvertApplicationDto;
import mq.QueueConsumer;
import po.AdminAdvert;
import service.AdminAdvertManager;

public class AdvertApplicationConsumer implements MessageListener,QueueConsumer {
	@Autowired
	private AdminAdvertManager aam;
	
	@Override
	public void onMessage(Message arg0) {
		TextMessage textMsg = (TextMessage) arg0;
		try {
			AdvertApplicationDto dto = (AdvertApplicationDto) convertStringToObject(textMsg.getText());
			if (dto!=null) {
				System.out.println(dto.getMerchantId());
				AdminAdvert aa = new AdminAdvert(); 
				//aa.setId(dto.getMerchantId());
				aa.setMerchantId(dto.getMerchantId());
				aa.setBalance(0);
				aa.setStatus("UnderReview");
				aam.addAdminAdv(aa);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Object convertStringToObject(String s) {
		AdvertApplicationDto result = null;
		ObjectMapper mapper=new ObjectMapper();
		try {
			result = mapper.readValue(s, AdvertApplicationDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
