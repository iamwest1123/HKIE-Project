package mq.impl;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.PersistenceContext;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.MerchantRegisterRequestDto;
import util.ProjectConstant;
import mq.QueueProducer;

@Component("merchantRegisterProducer")
public class MerchantRegisterProducer implements QueueProducer {
	
	@Autowired
	@Qualifier("newMerchentQueue")
	private Queue destination;
	private final JmsTemplate jmsTemplate;
	
	public MerchantRegisterProducer(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
	
	@Override
	public boolean send(Object obj) {
		if (!(obj instanceof MerchantRegisterRequestDto))
			return false;
		jmsTemplate.convertAndSend(destination, convertObjectToString(obj));
		return true;
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
