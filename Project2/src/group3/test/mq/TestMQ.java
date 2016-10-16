package group3.test.mq;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import group3.mq.MerchantRegisterConsumer;
import group3.mq.MerchantRegisterProducer;
import group3.po.MerchantInfo;

public class TestMQ {

	@Test
	public void testConstructXMLString() {
		MerchantRegisterProducer p = new MerchantRegisterProducer();
		MerchantInfo m = new MerchantInfo();
		m.setId(1);
		m.setMerchantName("2");
		m.setAge(3);
		m.setGender("M");
		m.setRegisterTime(new Date(Calendar.getInstance().getTimeInMillis()));
		m.setShopName("5");
		m.setTelNum("6");
		m.setAddress("7");
		m.setShopPicUrl("8");
		p.setMerchantInfo(m);
		System.out.println(p.constructXMLString());
	}

	@Test
	public void testStringToXML() {
		MerchantRegisterConsumer c = new MerchantRegisterConsumer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		MerchantInfo m = c.xmlToMerchantInfo("<Merchants><Merchant><id>1</id><age>3</age><date>2016-10-16 11:46:18</date><merchantName>2</merchantName><gender>M</gender><shopName>5</shopName><telNum>6</telNum><address>7</address><shopPicUrl>8</shopPicUrl></Merchant></Merchants>");
		System.out.println(m.getId());
		System.out.println(m.getMerchantName());
		System.out.println(m.getAge());
		System.out.println(sdf.format(m.getRegisterTime()));
		System.out.println(m.getGender());
		System.out.println(m.getShopName());
		System.out.println(m.getTelNum());
		System.out.println(m.getAddress());
		System.out.println(m.getShopPicUrl());
	}
	
//	@Test
	public void testMerchantRegisterProducer() {
		MerchantRegisterProducer p = new MerchantRegisterProducer();
		MerchantInfo m = new MerchantInfo();
//		m.setId(10540);
		m.setMerchantName("20");
		m.setAge(30);
		m.setGender("K");
		m.setShopName("50");
		m.setTelNum("60");
		m.setAddress("70");
		m.setShopPicUrl("80");
		p.setMerchantInfo(m);
		p.send();
	}
}
