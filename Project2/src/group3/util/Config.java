package group3.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import group3.mq.MerchantRegisterConsumer;

@WebListener
public class Config implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO shutdown
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO startup
		MerchantRegisterConsumer c = new MerchantRegisterConsumer();
		c.start();
	}

}
