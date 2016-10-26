package test.mq.impl;

import org.junit.Test;

import dto.MerchantRegisterRequestDto;
import mq.impl.MerchantRegisterConsumer;
import mq.impl.MerchantRegisterProducer;
import util.ProjectConstant;

public class TestMqImpl {
	MerchantRegisterProducer mrp = new MerchantRegisterProducer();
	MerchantRegisterConsumer mrc = new MerchantRegisterConsumer();
	
	@Test
	public void testMerchantRegisterRequestDto(){
		MerchantRegisterRequestDto mrDto = new MerchantRegisterRequestDto();
		mrDto.setMerchantId("1000");
		mrDto.setMerchantStatus(ProjectConstant.STATUS_UNDERREVIEW);
		String mrStr = mrp.convertObjectToString(mrDto);
		System.out.println(mrStr);
		mrDto = (MerchantRegisterRequestDto) mrc.convertStringToObject(mrStr);
		mrDto.getMerchantId();
		System.out.println(mrDto.getMerchantId() +"..."+ mrDto.getMerchantStatus());
	}
	
	@Test
	public void testMerchantRegisterProducer() {
		MerchantRegisterRequestDto mrDto = new MerchantRegisterRequestDto();
		mrDto.setMerchantId("1000");
		mrDto.setMerchantStatus(ProjectConstant.STATUS_UNDERREVIEW);
		mrp.send(mrDto);
	}
	
	@Test
	public void MerchantRegisterConsumer() {
		mrc.startConsumer();
	}
}
