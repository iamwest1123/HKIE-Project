package service.impl;

import po.MessageStatus;
import service.MessageStatusManager;

public class MessageStatusManagerImpl implements MessageStatusManager {

	@Override
	public MessageStatus createMessageStatus(String status) {
		return new MessageStatus(status);
	}

	@Override
	public MessageStatus createMessageStatus(String status, String reason) {
		return new MessageStatus(status,reason);
	}

}
