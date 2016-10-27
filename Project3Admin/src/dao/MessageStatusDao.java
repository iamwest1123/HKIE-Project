package dao;

import po.MessageStatus;

public interface MessageStatusDao {
	public MessageStatus createMessageStatus(String status);
	public MessageStatus createMessageStatus(String status,String reason);
}
