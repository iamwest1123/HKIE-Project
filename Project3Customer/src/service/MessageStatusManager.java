package service;

import po.MessageStatus;

public interface MessageStatusManager {
	public MessageStatus createMessageStatus(String status);
	public MessageStatus createMessageStatus(String status,String reason);
}
