package mq.impl;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.MerchantRegisterRequestDto;
import util.ProjectConstant;
import mq.QueueConsumer;

public class MerchantRegisterConsumer implements QueueConsumer {
	
	@Override
	public void startConsumer() {
		ConnectionFactory factory = new ActiveMQConnectionFactory(ProjectConstant.JMS_URL);
		Destination queue = new ActiveMQQueue(ProjectConstant.JMS_QUEUE_NEW_MERCHENT);
		Connection con = null;
		Session sen = null;
		MessageConsumer consumer = null;
		
		try {
			con = factory.createConnection();
			con.start();
			// message acknowledge mode
			sen = con.createSession(false, Session.AUTO_ACKNOWLEDGE); // true is transaction
			consumer = sen.createConsumer(queue);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			consumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message arg0) {
					try {
						String jsonInString = ((TextMessage)arg0).getText();
						MerchantRegisterRequestDto dto = (MerchantRegisterRequestDto) convertStringToObject(jsonInString);
						if (dto!=null) {
							// TODO: persist data to admin db
							System.out.println(dto.getMerchantId() +"..."+ dto.getMerchantStatus());
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
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
