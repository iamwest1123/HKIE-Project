package dao.impl;

import org.springframework.stereotype.Repository;

import dao.MessageStatusDao;
import po.MessageStatus;

@Repository
public class MessageStatusDaoImpl implements MessageStatusDao {
	
	@Override
	public MessageStatus createMessageStatus(String status) {
		return new MessageStatus(status);
	}

	@Override
	public MessageStatus createMessageStatus(String status, String reason) {
		return new MessageStatus(status, reason);
	}

}
