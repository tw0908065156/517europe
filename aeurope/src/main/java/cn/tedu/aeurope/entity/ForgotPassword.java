package cn.tedu.aeurope.entity;

import java.io.Serializable;
import java.util.Date;

	/**
	 * 忘記密碼，驗證碼存儲表
	 */
public class ForgotPassword implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer verifyId;
	private String clientEmail;
	private String validataCode;
	private Date expiredTime;
	public Integer getVerifyId() {
		return verifyId;
	}
	public void setVerifyId(Integer verifyId) {
		this.verifyId = verifyId;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getValidataCode() {
		return validataCode;
	}
	public void setValidataCode(String validataCode) {
		this.validataCode = validataCode;
	}
	public Date getExpiredTime() {
		return expiredTime;
	}
	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}
	@Override
	public String toString() {
		return "ForgotPassword [verifyId=" + verifyId + ", clientEmail=" + clientEmail + ", validataCode="
				+ validataCode + ", expiredTime=" + expiredTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientEmail == null) ? 0 : clientEmail.hashCode());
		result = prime * result + ((expiredTime == null) ? 0 : expiredTime.hashCode());
		result = prime * result + ((validataCode == null) ? 0 : validataCode.hashCode());
		result = prime * result + ((verifyId == null) ? 0 : verifyId.hashCode());
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
		ForgotPassword other = (ForgotPassword) obj;
		if (clientEmail == null) {
			if (other.clientEmail != null)
				return false;
		} else if (!clientEmail.equals(other.clientEmail))
			return false;
		if (expiredTime == null) {
			if (other.expiredTime != null)
				return false;
		} else if (!expiredTime.equals(other.expiredTime))
			return false;
		if (validataCode == null) {
			if (other.validataCode != null)
				return false;
		} else if (!validataCode.equals(other.validataCode))
			return false;
		if (verifyId == null) {
			if (other.verifyId != null)
				return false;
		} else if (!verifyId.equals(other.verifyId))
			return false;
		return true;
	}

}
