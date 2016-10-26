package mq;

public interface QueueProducer {
	public boolean send(Object obj);
	public String convertObjectToString(Object obj);
}
