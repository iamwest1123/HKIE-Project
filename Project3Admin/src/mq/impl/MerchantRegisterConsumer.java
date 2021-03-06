package mq.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.AdminStatusDao;
import dto.MerchantRegisterRequestDto;
import mq.QueueConsumer;
import po.AdminStatus;
import service.AdminStatusManager;

public class MerchantRegisterConsumer implements MessageListener,QueueConsumer {

	@Autowired
	private AdminStatusManager asm;
	
	
	@Override
	public void onMessage(Message arg0) {
		TextMessage textMsg = (TextMessage) arg0;
		try {
			MerchantRegisterRequestDto dto = (MerchantRegisterRequestDto) convertStringToObject(textMsg.getText());
			if (dto!=null) {
				AdminStatus as = new AdminStatus();
				as.setId(dto.getMerchantId());
				as.setStatus("UnderReview");
				System.out.println(as.getId());
				System.out.println(as.getStatus());
				asm.addStatus(as);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Object convertStringToObject(String s) {
		MerchantRegisterRequestDto result = null;
		ObjectMapper mapper=new ObjectMapper();
		try {
			result = mapper.readValue(s, MerchantRegisterRequestDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
