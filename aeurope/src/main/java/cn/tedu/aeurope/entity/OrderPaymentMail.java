package cn.tedu.aeurope.entity;

import java.io.Serializable;
import java.util.Date;
	/**
	 * email發送付款帳號
	 */
public class OrderPaymentMail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer paymentMailId;
	private Integer orderid;
	private Integer clientId;
	private String clientEmail;
	private String otherEmail;
	private Date sendTime;
	public Integer getPaymentMailId() {
		return paymentMailId;
	}
	public void setPaymentMailId(Integer paymentMailId) {
		this.paymentMailId = paymentMailId;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
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
	public String getOtherEmail() {
		return otherEmail;
	}
	public void setOtherEmail(String otherEmail) {
		this.otherEmail = otherEmail;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paymentMailId == null) ? 0 : paymentMailId.hashCode());
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
		OrderPaymentMail other = (OrderPaymentMail) obj;
		if (paymentMailId == null) {
			if (other.paymentMailId != null)
				return false;
		} else if (!paymentMailId.equals(other.paymentMailId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderPaymentMail [paymentMailId=" + paymentMailId + ", orderid=" + orderid + ", clientId=" + clientId
				+ ", clientEmail=" + clientEmail + ", otherEmail=" + otherEmail + "]";
	}

}
