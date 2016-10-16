package group3.mq;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import group3.dao.MerchantInfoDao;
import group3.dao.MerchantStatusDao;
import group3.dao.impl.MerchantInfoDaoImpl;
import group3.dao.impl.MerchantStatusDaoImpl;
import group3.po.MerchantInfo;
import group3.po.MerchantStatus;
import group3.util.ProjectConstant;

public class MerchantRegisterConsumer {
	SAXBuilder builder=new SAXBuilder();
	
	public void start() {
		MerchantInfoDao mid = new MerchantInfoDaoImpl();
		MerchantStatusDao msd = new MerchantStatusDaoImpl();
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
						String exampleXML = ((TextMessage)arg0).getText();
//						System.out.println(exampleXML);
						MerchantInfo mInfo = xmlToMerchantInfo(exampleXML);
						MerchantInfo pullInfo = null;
						if (mInfo.getId()==null) {
							mid.addMerchantInfo(mInfo);
							pullInfo = mid.findMerchantInfoByName(mInfo.getMerchantName());
							if (pullInfo==null) {
								System.out.println("Error: unable to add merchant");
								throw new Exception();
							} else {
								MerchantStatus ms = new MerchantStatus();
								ms.setId(pullInfo.getId());
								ms.setStatus(ProjectConstant.MERCHANT_STATUS_UNDERREVIEW);
								msd.addMerchantStatus(ms);
							}
						} else {
							mid.updateMerchantInfo(mInfo);
							pullInfo = mid.findMerchantInfo(mInfo.getId());
							if (pullInfo==null) {
								System.out.println("Error: unable to update merchant");
								throw new Exception();
							} else {
								MerchantStatus ms = new MerchantStatus();
								ms.setId(pullInfo.getId());
								ms.setStatus(ProjectConstant.MERCHANT_STATUS_UNDERREVIEW);
								msd.updateMerchantStatus(ms);
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MerchantInfo xmlToMerchantInfo(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		MerchantInfo result = null;
		InputStream stream = null;
		Document xmlDocument = null;
		try {
			stream = new ByteArrayInputStream(s.getBytes("UTF-8"));
			xmlDocument = builder.build(stream);
			Element root=xmlDocument.getRootElement();
			List<Element> merchents= root.getChildren();
			for(Element merchent:merchents){
				String idStr = merchent.getChildText("id");
				Integer id = (idStr!=null)?Integer.parseInt(idStr):null;
				String merchantName = merchent.getChildText("merchantName");
				String ageStr = merchent.getChildText("age");
				Integer age = (ageStr!=null)?Integer.parseInt(ageStr):null;
				String dateStr = merchent.getChildText("date");
				java.util.Date date = (dateStr!=null)?sdf.parse(dateStr):null;
				// TODO
				String gender = merchent.getChildText("gender");
				String shopName = merchent.getChildText("shopName");
				String telNum = merchent.getChildText("telNum");
				String address = merchent.getChildText("address");
				String shopPicUrl = merchent.getChildText("shopPicUrl");
				
				MerchantInfo mInfo=new MerchantInfo();
				mInfo.setId(id);
				mInfo.setMerchantName(merchantName);
				mInfo.setAge(age);
				mInfo.setRegisterTime(new java.sql.Date(date.getTime()));
				mInfo.setGender(gender);
				mInfo.setShopName(shopName);
				mInfo.setTelNum(telNum);
				mInfo.setAddress(address);
				mInfo.setShopPicUrl(shopPicUrl);
				result = mInfo;
				
//				System.out.println(result.getId());
//				System.out.println(result.getMerchantName());
//				System.out.println(result.getAge());
//				System.out.println(sdf.format(result.getRegisterTime()));
//				System.out.println(result.getGender());
//				System.out.println(result.getShopName());
//				System.out.println(result.getTelNum());
//				System.out.println(result.getAddress());
//				System.out.println(result.getShopPicUrl());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
