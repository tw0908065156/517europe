package cn.tedu.aeurope.entity;

import java.io.Serializable;
	/**
	 * 訂單表~景點明細
	 */
public class ScenicOrder implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer scenicOrderId;
	private Integer orderid; //FOREIGN KEY, REFERENCES t_scart_order(orderid)
	private Integer sid;
	private String tname;
	private String scenic;
	private Integer sticket;
	private String scode;
	private Double hotelWeights;
	private Double busWeights;
	public Integer getScenicOrderId() {
		return scenicOrderId;
	}
	public void setScenicOrderId(Integer scenicOrderId) {
		this.scenicOrderId = scenicOrderId;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getScenic() {
		return scenic;
	}
	public void setScenic(String scenic) {
		this.scenic = scenic;
	}
	public Integer getSticket() {
		return sticket;
	}
	public void setSticket(Integer sticket) {
		this.sticket = sticket;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public Double getHotelWeights() {
		return hotelWeights;
	}
	public void setHotelWeights(Double hotelWeights) {
		this.hotelWeights = hotelWeights;
	}
	public Double getBusWeights() {
		return busWeights;
	}
	public void setBusWeights(Double busWeights) {
		this.busWeights = busWeights;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scenicOrderId == null) ? 0 : scenicOrderId.hashCode());
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
		ScenicOrder other = (ScenicOrder) obj;
		if (scenicOrderId == null) {
			if (other.scenicOrderId != null)
				return false;
		} else if (!scenicOrderId.equals(other.scenicOrderId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ScenicOrder [scenicOrderId=" + scenicOrderId + ", orderid=" + orderid + ", sid=" + sid + ", tname="
				+ tname + ", scenic=" + scenic + ", sticket=" + sticket + ", scode=" + scode + ", hotelWeights="
				+ hotelWeights + ", busWeights=" + busWeights + "]";
	}

}
