package cn.tedu.aeurope.entity;

/**
 * 用戶表
 */
public class Client extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Integer clientId;
	private String clientEmail;
	private String clientPassword;
	private String psSalt;
	private String clientNickname;
	private String clientPhone;
	private Integer clientGender;
	private Integer isDelete;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
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
		Client other = (Client) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientEmail=" + clientEmail + ", clientPassword=" + clientPassword
				+ ", psSalt=" + psSalt + ", clientNickname=" + clientNickname + ", clientPhone=" + clientPhone
				+ ", clientGender=" + clientGender + ", isDelete=" + isDelete + "]";
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientPassword() {
		return clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	public String getPsSalt() {
		return psSalt;
	}

	public void setPsSalt(String psSalt) {
		this.psSalt = psSalt;
	}

	public String getClientNickname() {
		return clientNickname;
	}

	public void setClientNickname(String clientNickname) {
		this.clientNickname = clientNickname;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public Integer getClientGender() {
		return clientGender;
	}

	public void setClientGender(Integer clientGender) {
		this.clientGender = clientGender;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}
