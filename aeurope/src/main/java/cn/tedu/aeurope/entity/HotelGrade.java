package cn.tedu.aeurope.entity;

import java.io.Serializable;
	/**
	 * 飯店等級表
	 */
public class HotelGrade implements Serializable{	

	private static final long serialVersionUID = 1L;
	
	private Integer hid;
	private String hotelGrade;
	private Integer hotelDetails;
	private String hpriority;
	private String hotelFare;
	
	@Override
	public String toString() {
		return "HotelGrade [hid=" + hid + ", hotelGrade=" + hotelGrade + ", hotelDetails=" + hotelDetails
				+ ", hpriority=" + hpriority + ", hotelFare=" + hotelFare + "]";
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public String getHotelGrade() {
		return hotelGrade;
	}
	public void setHotelGrade(String hotelGrade) {
		this.hotelGrade = hotelGrade;
	}
	public Integer getHotelDetails() {
		return hotelDetails;
	}
	public void setHotelDetails(Integer hotelDetails) {
		this.hotelDetails = hotelDetails;
	}
	public String getHpriority() {
		return hpriority;
	}
	public void setHpriority(String hpriority) {
		this.hpriority = hpriority;
	}
	public String getHotelFare() {
		return hotelFare;
	}
	public void setHotelFare(String hotelFare) {
		this.hotelFare = hotelFare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hid == null) ? 0 : hid.hashCode());
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
		HotelGrade other = (HotelGrade) obj;
		if (hid == null) {
			if (other.hid != null)
				return false;
		} else if (!hid.equals(other.hid))
			return false;
		return true;
	}
}
