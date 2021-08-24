package cn.tedu.aeurope.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 訂單付款信息
 */
public class OrderPayment implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer paymentId;
	private Integer orderid;
	private Integer payableAmount;
	private Date payableTime;
	private Integer paymentAmount;
	private Date paymentTime;
	private String paymentMethod;
	private String financialReceipt;
	private String referenceInfo;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(Integer payableAmount) {
		this.payableAmount = payableAmount;
	}

	public Date getPayableTime() {
		return payableTime;
	}

	public void setPayableTime(Date payableTime) {
		this.payableTime = payableTime;
	}

	public Integer getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Integer paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getFinancialReceipt() {
		return financialReceipt;
	}

	public void setFinancialReceipt(String financialReceipt) {
		this.financialReceipt = financialReceipt;
	}

	public String getReferenceInfo() {
		return referenceInfo;
	}

	public void setReferenceInfo(String referenceInfo) {
		this.referenceInfo = referenceInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paymentId == null) ? 0 : paymentId.hashCode());
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
		OrderPayment other = (OrderPayment) obj;
		if (paymentId == null) {
			if (other.paymentId != null)
				return false;
		} else if (!paymentId.equals(other.paymentId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderPayment [paymentId=" + paymentId + ", orderid=" + orderid + ", payableAmount=" + payableAmount
				+ ", payableTime=" + payableTime + ", paymentAmount=" + paymentAmount + ", paymentTime=" + paymentTime
				+ ", paymentMethod=" + paymentMethod + ", financialReceipt=" + financialReceipt + ", referenceInfo="
				+ referenceInfo + "]";
	}

}
