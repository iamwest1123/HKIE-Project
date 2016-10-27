package po;

public class MessageStatus {

	String status;
	String reason;
	public MessageStatus(String status, String reason) {
		this.status = status;
		this.reason = reason;
	}
	public MessageStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
