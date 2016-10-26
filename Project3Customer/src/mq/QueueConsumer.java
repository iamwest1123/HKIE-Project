package mq;

public interface QueueConsumer {
	public void startConsumer();
	public Object convertStringToObject(String s);
}
