package cn.tedu.aeurope.entity;

/**
 * 訂單明細實體類
 */
public class ScartOrder extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Integer orderid;
	private Integer clientId;
	private String clientEmail;
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
	

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
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

	public Integer getClientId() {
		return clientId;
	}
	
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	
	public Integer getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
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
		ScartOrder other = (ScartOrder) obj;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScartOrder [orderid=" + orderid + ", clientId=" + clientId + ", clientEmail=" + clientEmail + ", hid="
				+ hid + ", daysid=" + daysid + ", personid=" + personid + ", flightsidList=" + flightsidList
				+ ", hotelAppend=" + hotelAppend + ", daysAppend=" + daysAppend + ", personAppend=" + personAppend
				+ ", flightsAppend=" + flightsAppend + ", otherAppend=" + otherAppend + ", orderStatus=" + orderStatus
				+ "]";
	}




}
