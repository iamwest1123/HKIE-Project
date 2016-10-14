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
	private ConnectionFactory factory = new ActiveMQConnectionFactory(ProjectConstant.JMS_URL);
	private Destination queue = new ActiveMQQueue(ProjectConstant.JMS_QUEUE_NEW_MERCHENT);
	private XMLOutputter outputter = new XMLOutputter();
	private MerchantInfo merchantInfo;
	
	public boolean send() {
		boolean isSuccess = false;
		Connection con = null;
		Session sen = null;
		MessageProducer producer = null;
		
		try {
			con = factory.createConnection();
			con.start();
			// message acknowledge mode
			sen = con.createSession(false, Session.AUTO_ACKNOWLEDGE); // true is transaction
			
			producer = sen.createProducer(queue);
			
			TextMessage msg = sen.createTextMessage(constructXMLString());
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
		Element date=new Element("date");
		Element gender=new Element("gender");
		Element shopName=new Element("shopName");
		Element telNum=new Element("telNum");
		Element address=new Element("address");
		Element shopPicUrl=new Element("shopPicUrl");
		if (merchantInfo.getId()!=null) {
			id.setText(merchantInfo.getId().toString());
			merchant.addContent(id);
		}
		if (merchantInfo.getAge()!=null) {
			age.setText(merchantInfo.getAge().toString());
			merchant.addContent(age);
		}
		if (merchantInfo.getRegisterTime()!=null) {
			// TODO to string then add content
		}
		merchantName.setText(merchantInfo.getMerchantName());
		gender.setText(merchantInfo.getGender());
		shopName.setText(merchantInfo.getShopName());
		telNum.setText(merchantInfo.getTelNum());
		address.setText(merchantInfo.getAddress());
		shopPicUrl.setText(merchantInfo.getShopPicUrl());
		merchant.addContent(merchantName);
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
