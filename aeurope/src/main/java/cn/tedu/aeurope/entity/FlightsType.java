package cn.tedu.aeurope.entity;

import java.io.Serializable;
/**
	 * 航班類型列表
	 */
public class FlightsType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer flightsid;
	private String flightsType;
	private String flightsName;
	private String flightsCode;
	private String transferType;
	private Integer fpriority;
	
	public Integer getFlightsid() {
		return flightsid;
	}
	public void setFlightsid(Integer flightsid) {
		this.flightsid = flightsid;
	}
	public String getFlightsType() {
		return flightsType;
	}
	public void setFlightsType(String flightsType) {
		this.flightsType = flightsType;
	}
	public String getFlightsCode() {
		return flightsCode;
	}
	public void setFlightsCode(String flightsCode) {
		this.flightsCode = flightsCode;
	}
	public String getTransferType() {
		return transferType;
	}
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}
	public Integer getFpriority() {
		return fpriority;
	}
	public void setFpriority(Integer fpriority) {
		this.fpriority = fpriority;
	}
	public String getFlightsName() {
		return flightsName;
	}
	public void setFlightsName(String flightsName) {
		this.flightsName = flightsName;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightsid == null) ? 0 : flightsid.hashCode());
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
		FlightsType other = (FlightsType) obj;
		if (flightsid == null) {
			if (other.flightsid != null)
				return false;
		} else if (!flightsid.equals(other.flightsid))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "FlightsType [flightsid=" + flightsid + ", flightsType=" + flightsType + ", flightsName=" + flightsName
				+ ", flightsCode=" + flightsCode + ", transferType=" + transferType + ", fpriority=" + fpriority + "]";
	}

}
