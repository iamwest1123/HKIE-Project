package test.mq.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import dto.MerchantRegisterRequestDto;
import mq.impl.MerchantRegisterConsumer;
import mq.impl.MerchantRegisterProducer;
import util.ProjectConstant;

public class TestMqImpl {
	MerchantRegisterConsumer mrc = new MerchantRegisterConsumer();
		
	@Test
	@Transactional
	public void testMerchantRegisterProducer() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MerchantRegisterProducer producer = (MerchantRegisterProducer) context.getBean("merchantRegisterProducer");
		System.out.println(producer);
		MerchantRegisterRequestDto mrDto = new MerchantRegisterRequestDto();
		mrDto.setMerchantId("1234");
		mrDto.setMerchantStatus(ProjectConstant.STATUS_UNDERREVIEW);
		producer.send(mrDto);
	}
		
}
