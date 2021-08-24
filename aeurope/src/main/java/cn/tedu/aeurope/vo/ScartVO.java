package cn.tedu.aeurope.vo;

import java.io.Serializable;

/**
	 * 購物車VO類
	 */
public class ScartVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cartid;
	private String clientEmail;
	private String ctname;
	private String tname;
	private Integer tpriority;
	private String scenic;
	private Integer sticket;
	private String stime;
	private String scenicWiki;
	private Integer spriority;
	private String scode;
	private Integer clientId;
	private Integer sid;
	private Double hotelWeights;
	private Double busWeights;


	public Integer getCartid() {
		return cartid;
	}

	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getCtname() {
		return ctname;
	}

	public void setCtname(String ctname) {
		this.ctname = ctname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Integer getTpriority() {
		return tpriority;
	}

	public void setTpriority(Integer tpriority) {
		this.tpriority = tpriority;
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

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getScenicWiki() {
		return scenicWiki;
	}

	public void setScenicWiki(String scenicWiki) {
		this.scenicWiki = scenicWiki;
	}

	public Integer getSpriority() {
		return spriority;
	}

	public void setSpriority(Integer spriority) {
		this.spriority = spriority;
	}

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartid == null) ? 0 : cartid.hashCode());
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
		ScartVO other = (ScartVO) obj;
		if (cartid == null) {
			if (other.cartid != null)
				return false;
		} else if (!cartid.equals(other.cartid))
			return false;
		return true;
	}


	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}


	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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

	@Override
	public String toString() {
		return "ScartVO [cartid=" + cartid + ", clientEmail=" + clientEmail + ", ctname=" + ctname + ", tname=" + tname
				+ ", tpriority=" + tpriority + ", scenic=" + scenic + ", sticket=" + sticket + ", stime=" + stime
				+ ", scenicWiki=" + scenicWiki + ", spriority=" + spriority + ", scode=" + scode + ", clientId="
				+ clientId + ", sid=" + sid + ", hotelWeights=" + hotelWeights + ", busWeights=" + busWeights + "]";
	}
}
