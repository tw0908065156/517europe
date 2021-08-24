package cn.tedu.aeurope.entity;

import java.io.Serializable;
/**
	 * 人數列表及車型配置
	 */
public class PersonNumber implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer personid;
	private String totalPerson;
	private Integer personNumber;
	private String busModel;
	private Integer busFare;
	private Integer driverTip;
	private Integer personFare;
	private Integer ppriority;
	
	public Integer getPersonid() {
		return personid;
	}
	public void setPersonid(Integer personid) {
		this.personid = personid;
	}
	public String getTotalPerson() {
		return totalPerson;
	}
	public void setTotalPerson(String totalPerson) {
		this.totalPerson = totalPerson;
	}
	public Integer getPersonNumber() {
		return personNumber;
	}
	public void setPersonNumber(Integer personNumber) {
		this.personNumber = personNumber;
	}
	public String getBusModel() {
		return busModel;
	}
	public void setBusModel(String busModel) {
		this.busModel = busModel;
	}
	public Integer getBusFare() {
		return busFare;
	}
	public void setBusFare(Integer busFare) {
		this.busFare = busFare;
	}
	public Integer getDriverTip() {
		return driverTip;
	}
	public void setDriverTip(Integer driverTip) {
		this.driverTip = driverTip;
	}
	public Integer getPersonFare() {
		return personFare;
	}
	public void setPersonFare(Integer personFare) {
		this.personFare = personFare;
	}
	public Integer getPpriority() {
		return ppriority;
	}
	public void setPpriority(Integer ppriority) {
		this.ppriority = ppriority;
	}
	
	@Override
	public String toString() {
		return "PersonNumber [personid=" + personid + ", totalPerson=" + totalPerson + ", personNumber=" + personNumber
				+ ", busModel=" + busModel + ", busFare=" + busFare + ", driverTip=" + driverTip + ", personFare="
				+ personFare + ", ppriority=" + ppriority + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personid == null) ? 0 : personid.hashCode());
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
		PersonNumber other = (PersonNumber) obj;
		if (personid == null) {
			if (other.personid != null)
				return false;
		} else if (!personid.equals(other.personid))
			return false;
		return true;
	}

}
