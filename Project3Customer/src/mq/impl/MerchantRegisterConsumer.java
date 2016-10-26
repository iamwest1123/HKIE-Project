package mq.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.MerchantRegisterRequestDto;
import mq.QueueConsumer;

public class MerchantRegisterConsumer implements MessageListener,QueueConsumer {

	@Override
	public void onMessage(Message arg0) {
		TextMessage textMsg = (TextMessage) arg0;
		try {
			MerchantRegisterRequestDto dto = (MerchantRegisterRequestDto) convertStringToObject(textMsg.getText());
			if (dto!=null) {
				// TODO: persist data to admin db
				System.out.println(dto.getMerchantId() +"..."+ dto.getMerchantStatus());
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
