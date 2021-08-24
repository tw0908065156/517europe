package cn.tedu.aeurope.entity;
	/**
	 * 聯絡我們 Contact us收到信息儲存類
	 */
public class ContactMessage extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private Integer messageId;
	private Integer clientId;
	private String clientNickname;
	private String clientEmail;
	private String messageSubject;
	private String messageDetail;
	private Integer messageStatus;
	private String messageFeedback;
	
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getClientNickname() {
		return clientNickname;
	}
	public void setClientNickname(String clientNickname) {
		this.clientNickname = clientNickname;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getMessageSubject() {
		return messageSubject;
	}
	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}
	public String getMessageDetail() {
		return messageDetail;
	}
	public void setMessageDetail(String messageDetail) {
		this.messageDetail = messageDetail;
	}
	public Integer getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(Integer messageStatus) {
		this.messageStatus = messageStatus;
	}
	public String getMessageFeedback() {
		return messageFeedback;
	}
	public void setMessageFeedback(String messageFeedback) {
		this.messageFeedback = messageFeedback;
	}
	
	@Override
	public String toString() {
		return "ContactMessage [messageId=" + messageId + ", clientId=" + clientId + ", clientNickname="
				+ clientNickname + ", clientEmail=" + clientEmail + ", messageSubject=" + messageSubject
				+ ", messageDetail=" + messageDetail + ", messageStatus=" + messageStatus + ", messageFeedback="
				+ messageFeedback + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messageId == null) ? 0 : messageId.hashCode());
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
		ContactMessage other = (ContactMessage) obj;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		return true;
	}

}
