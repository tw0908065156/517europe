package cn.tedu.aeurope.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 訂單明細VO
 */
public class OrderVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer orderid;
	private Integer clientId;
	private Integer hid;
	private Integer daysid;
	private Integer personid;
	private String flightsidList;
	private String hotelAppend;
	private String daysAppend;
	private String personAppend;
	private String flightsAppend;
	private String otherAppend;
	private Integer orderStatus;
	private String orderStatusDesc;
	private Date createdTime;
	private String feedbackName;
	private String feedbackPdf;
	private String sids;
	private String townDetails;
	private String dateFmt;
	private String payableAmount;
	private Date payableTime;
	private String clientEmail;


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

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public Integer getDaysid() {
		return daysid;
	}

	public void setDaysid(Integer daysid) {
		this.daysid = daysid;
	}

	public Integer getPersonid() {
		return personid;
	}

	public void setPersonid(Integer personid) {
		this.personid = personid;
	}

	public String getFlightsidList() {
		return flightsidList;
	}

	public void setFlightsidList(String flightsidList) {
		this.flightsidList = flightsidList;
	}

	public String getHotelAppend() {
		return hotelAppend;
	}

	public void setHotelAppend(String hotelAppend) {
		this.hotelAppend = hotelAppend;
	}

	public String getDaysAppend() {
		return daysAppend;
	}

	public void setDaysAppend(String daysAppend) {
		this.daysAppend = daysAppend;
	}

	public String getPersonAppend() {
		return personAppend;
	}

	public void setPersonAppend(String personAppend) {
		this.personAppend = personAppend;
	}

	public String getFlightsAppend() {
		return flightsAppend;
	}

	public void setFlightsAppend(String flightsAppend) {
		this.flightsAppend = flightsAppend;
	}

	public String getOtherAppend() {
		return otherAppend;
	}

	public void setOtherAppend(String otherAppend) {
		this.otherAppend = otherAppend;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getSid() {
		return sids;
	}

	public void setSid(String sid) {
		this.sids = sid;
	}

	public String getTownDetails() {
		return townDetails;
	}

	public void setTownDetails(String townDetails) {
		this.townDetails = townDetails;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getFeedbackName() {
		return feedbackName;
	}

	public void setFeedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
	}

	public String getFeedbackPdf() {
		return feedbackPdf;
	}

	public void setFeedbackPdf(String feedbackPdf) {
		this.feedbackPdf = feedbackPdf;
	}

	public String getSids() {
		return sids;
	}

	public void setSids(String sids) {
		this.sids = sids;
	}

	public String getOrderStatusDesc() {
		return orderStatusDesc;
	}

	public void setOrderStatusDesc(String orderStatusDesc) {
		this.orderStatusDesc = orderStatusDesc;
	}

	public String getDateFmt() {
		return dateFmt;
	}

	public void setDateFmt(String dateFmt) {
		this.dateFmt = dateFmt;
	}

	public String getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(String payableAmount) {
		this.payableAmount = payableAmount;
	}

	public Date getPayableTime() {
		return payableTime;
	}

	public void setPayableTime(Date payableTime) {
		this.payableTime = payableTime;
	}
	
	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
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
		OrderVO other = (OrderVO) obj;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderVO [orderid=" + orderid + ", clientId=" + clientId + ", hid=" + hid + ", daysid=" + daysid
				+ ", personid=" + personid + ", flightsidList=" + flightsidList + ", hotelAppend=" + hotelAppend
				+ ", daysAppend=" + daysAppend + ", personAppend=" + personAppend + ", flightsAppend=" + flightsAppend
				+ ", otherAppend=" + otherAppend + ", orderStatus=" + orderStatus + ", orderStatusDesc="
				+ orderStatusDesc + ", createdTime=" + createdTime + ", feedbackName=" + feedbackName + ", feedbackPdf="
				+ feedbackPdf + ", sids=" + sids + ", townDetails=" + townDetails + ", dateFmt=" + dateFmt
				+ ", payableAmount=" + payableAmount + ", payableTime=" + payableTime + ", clientEmail=" + clientEmail
				+ "]";
	}


}
