package mq.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.AdvertApplicationDto;
import mq.QueueConsumer;

public class AdvertApplicationConsumer implements MessageListener,QueueConsumer {

	@Override
	public void onMessage(Message arg0) {
		TextMessage textMsg = (TextMessage) arg0;
		try {
			AdvertApplicationDto dto = (AdvertApplicationDto) convertStringToObject(textMsg.getText());
			if (dto!=null) {
				// TODO: persist data to admin db
				System.out.println(dto.getMerchantId());
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
