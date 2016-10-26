package mq.impl;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.MerchantRegisterRequestDto;
import util.ProjectConstant;
import mq.QueueProducer;

public class MerchantRegisterProducer implements QueueProducer {
	private ConnectionFactory factory = new ActiveMQConnectionFactory(ProjectConstant.JMS_URL);
	private Destination queue = new ActiveMQQueue(ProjectConstant.JMS_QUEUE_NEW_MERCHENT);
	
	@Override
	public boolean send(Object obj) {
		boolean isSuccess = false;
		Connection con = null;
		Session sen = null;
		MessageProducer producer = null;
		if (!(obj instanceof MerchantRegisterRequestDto))
			return false;
		try {
			con = factory.createConnection();
			con.start();
			// message acknowledge mode
			sen = con.createSession(false, Session.AUTO_ACKNOWLEDGE); // true is transaction
			
			producer = sen.createProducer(queue);
			
			TextMessage msg = sen.createTextMessage(convertObjectToString(obj));
			producer.send(msg);
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		} finally {
			try {
				producer.close();
			} catch (JMSException e) { }
			try {
				sen.close();
			} catch (JMSException e) { }
			try {
				con.close();
			} catch (JMSException e) { }
		}
		return isSuccess;
	}

	@Override
	public String convertObjectToString(Object obj) {
		String result = null;
		ObjectMapper mapper=new ObjectMapper();
		if (!(obj instanceof MerchantRegisterRequestDto))
			return null;
		MerchantRegisterRequestDto dto = (MerchantRegisterRequestDto) obj;
		try {
			result = mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

}
