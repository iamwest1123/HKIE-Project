package group3.mq;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
import org.jdom.input.SAXBuilder;

import group3.dao.MerchantInfoDao;
import group3.dao.impl.MerchantInfoDaoImpl;
import group3.po.MerchantInfo;
import group3.util.ProjectConstant;

public class MerchantRegisterConsumer {
	
	public void start() {
		MerchantInfoDao mid = new MerchantInfoDaoImpl();
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
				SAXBuilder builder=new SAXBuilder();

				@Override
				public void onMessage(Message arg0) {
					try {
						System.out.println(((TextMessage)arg0).getText());
						String exampleXML = ((TextMessage)arg0).getText();
						InputStream stream = new ByteArrayInputStream(exampleXML.getBytes("UTF-8"));
						Document xmlDocument = builder.build(stream);
						Element root=xmlDocument.getRootElement();
						List<Element> merchents= root.getChildren();
						for(Element merchent:merchents){
							String idStr = merchent.getChildText("id");
							Integer id = (idStr!=null)?Integer.parseInt(idStr):null;
							String merchantName = merchent.getChildText("merchantName");
							String ageStr = merchent.getChildText("age");
							Integer age = (ageStr!=null)?Integer.parseInt(ageStr):null;
							String gender = merchent.getChildText("gender");
							String shopName = merchent.getChildText("shopName");
							String telNum = merchent.getChildText("telNum");
							String address = merchent.getChildText("address");
							String shopPicUrl = merchent.getChildText("shopPicUrl");
							
							MerchantInfo mInfo=new MerchantInfo();
							mInfo.setId(id);
							mInfo.setMerchantName(merchantName);
							mInfo.setAge(age);
							mInfo.setGender(gender);
							mInfo.setShopName(shopName);
							mInfo.setTelNum(telNum);
							mInfo.setAddress(address);
							mInfo.setShopPicUrl(shopPicUrl);
							if (mInfo.getId()==null)
								mid.addMerchantInfo(mInfo);
							else
								mid.updateMerchantInfo(mInfo);
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
}
