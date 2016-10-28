package mq.impl;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.AdvertApplicationDto;
import mq.QueueProducer;

@Component
public class AdvertApplicationProducer implements QueueProducer {
	
	@Autowired
	@Qualifier("advertApplicationQueue")
	private Queue destination;
	private final JmsTemplate jmsTemplate;
	
	public AdvertApplicationProducer(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
	
	@Override
	public boolean send(Object obj) {
		if (!(obj instanceof AdvertApplicationDto))
			return false;
		jmsTemplate.convertAndSend(destination, convertObjectToString(obj));
		return true;
	}

	@Override
	public String convertObjectToString(Object obj) {
		String result = null;
		ObjectMapper mapper=new ObjectMapper();
		if (!(obj instanceof AdvertApplicationDto))
			return null;
		AdvertApplicationDto dto = (AdvertApplicationDto) obj;
		try {
			result = mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
