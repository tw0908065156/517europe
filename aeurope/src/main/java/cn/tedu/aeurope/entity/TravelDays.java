package cn.tedu.aeurope.entity;

import java.io.Serializable;
	/**
	 * 旅遊天數列表
	 */
public class TravelDays implements  Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer daysid;
	private String travelDays;
	private Integer stayNights;
	private Integer dpriority;
	public Integer getDaysid() {
		return daysid;
	}
	public void setDaysid(Integer daysid) {
		this.daysid = daysid;
	}
	public String getTravelDays() {
		return travelDays;
	}
	public void setTravelDays(String travelDays) {
		this.travelDays = travelDays;
	}
	public Integer getStayNights() {
		return stayNights;
	}
	public void setStayNights(Integer stayNights) {
		this.stayNights = stayNights;
	}
	public Integer getDpriority() {
		return dpriority;
	}
	public void setDpriority(Integer dpriority) {
		this.dpriority = dpriority;
	}
	
	@Override
	public String toString() {
		return "TravelDays [daysid=" + daysid + ", travelDays=" + travelDays + ", stayNights=" + stayNights
				+ ", dpriority=" + dpriority + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((daysid == null) ? 0 : daysid.hashCode());
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
		TravelDays other = (TravelDays) obj;
		if (daysid == null) {
			if (other.daysid != null)
				return false;
		} else if (!daysid.equals(other.daysid))
			return false;
		return true;
	}

}
