package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MessageStatusDao;
import po.MessageStatus;
import service.MessageStatusManager;

@Service
public class MessageStatusManagerImpl implements MessageStatusManager {

	@Autowired
	private MessageStatusDao msd;
	
	@Override
	public MessageStatus createMessageStatus(String status) {
		return msd.createMessageStatus(status);
	}

	@Override
	public MessageStatus createMessageStatus(String status, String reason) {
		return msd.createMessageStatus(status, reason);
	}

}
