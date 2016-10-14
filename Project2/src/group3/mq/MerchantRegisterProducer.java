package group3.mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import group3.po.MerchantInfo;
import group3.util.ProjectConstant;

public class MerchantRegisterProducer {
	private XMLOutputter outputter = new XMLOutputter();
	private MerchantInfo merchantInfo;
	
	public boolean send() {
		ConnectionFactory factory = new ActiveMQConnectionFactory(ProjectConstant.JMS_URL);
		Destination queue = new ActiveMQQueue(ProjectConstant.JMS_QUEUE_NEW_MERCHENT);
		Connection con = null;
		Session sen = null;
		MessageProducer producer = null;
		
		try {
			con = factory.createConnection();
			con.start();
			// message acknowledge mode
			sen = con.createSession(false, Session.AUTO_ACKNOWLEDGE); // true is transaction
			
			producer = sen.createProducer(queue);
			
			TextMessage msg = sen.createTextMessage(" Ryan BB <3 ");
			producer.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
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
		
		return true;
	}
	
	public String constructXMLString() {
		if (merchantInfo == null)
			return null;
		Document doc=new Document();
		Element merchants=new Element("Merchants");
		doc.setRootElement(merchants);
		Element merchant=new Element("Merchant");
		Element id=new Element("id");
		Element merchantName=new Element("merchantName");
		Element age=new Element("age");
		Element gender=new Element("gender");
		Element shopName=new Element("shopName");
		Element telNum=new Element("telNum");
		Element address=new Element("address");
		Element shopPicUrl=new Element("shopPicUrl");
		id.setText(merchantInfo.getId().toString());
		merchantName.setText(merchantInfo.getMerchantName());
		age.setText(merchantInfo.getAge().toString());
		gender.setText(merchantInfo.getGender());
		shopName.setText(merchantInfo.getShopName());
		telNum.setText(merchantInfo.getTelNum());
		address.setText(merchantInfo.getAddress());
		shopPicUrl.setText(merchantInfo.getShopPicUrl());
		merchant.addContent(id);
		merchant.addContent(merchantName);
		merchant.addContent(age);
		merchant.addContent(gender);
		merchant.addContent(shopName);
		merchant.addContent(telNum);
		merchant.addContent(address);
		merchant.addContent(shopPicUrl);
		merchants.addContent(merchant);
		
		return outputter.outputString(doc);
	}

	public MerchantInfo getMerchantInfo() {
		return merchantInfo;
	}
	public void setMerchantInfo(MerchantInfo merchantInfo) {
		this.merchantInfo = merchantInfo;
	}
}
