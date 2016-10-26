package dto;

public class MerchantRegisterRequestDto {
	private String merchantId;
	private String merchantStatus;
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantStatus() {
		return merchantStatus;
	}
	public void setMerchantStatus(String merchantStatus) {
		this.merchantStatus = merchantStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((merchantId == null) ? 0 : merchantId.hashCode());
		result = prime * result + ((merchantStatus == null) ? 0 : merchantStatus.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MerchantRegisterRequestDto other = (MerchantRegisterRequestDto) obj;
		if (merchantId == null) {
			if (other.merchantId != null)
				return false;
		} else if (!merchantId.equals(other.merchantId))
			return false;
		if (merchantStatus == null) {
			if (other.merchantStatus != null)
				return false;
		} else if (!merchantStatus.equals(other.merchantStatus))
			return false;
		return true;
	}
}
