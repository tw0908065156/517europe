package cn.tedu.aeurope.entity;

import java.io.Serializable;
	/**
	 * 計算團費的臨時表
	 */
public class CalculateTemp  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer ctid;
	private String stime;
	private String scode;
	private float hotelWeights;
	private float busWeights;
	private Integer sdays;
	
	public Integer getCtid() {
		return ctid;
	}
	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public float getHotelWeights() {
		return hotelWeights;
	}
	public void setHotelWeights(float hotelWeights) {
		this.hotelWeights = hotelWeights;
	}
	public float getBusWeights() {
		return busWeights;
	}
	public void setBusWeights(float busWeights) {
		this.busWeights = busWeights;
	}
	public Integer getSdays() {
		return sdays;
	}
	public void setSdays(Integer sdays) {
		this.sdays = sdays;
	}
	@Override
	public String toString() {
		return "CalculateTemp [ctid=" + ctid + ", stime=" + stime + ", scode=" + scode + ", hotelWeights="
				+ hotelWeights + ", busWeights=" + busWeights + ", sdays=" + sdays + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ctid == null) ? 0 : ctid.hashCode());
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
		CalculateTemp other = (CalculateTemp) obj;
		if (ctid == null) {
			if (other.ctid != null)
				return false;
		} else if (!ctid.equals(other.ctid))
			return false;
		return true;
	}


}
