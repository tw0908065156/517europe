package cn.tedu.aeurope.entity;

import java.io.Serializable;

/**
 * 景點明細資料表(含城市) 
 * @scode 唯一，城市scode="國家代碼+城市代碼+00000", 景點scode="國家代碼+城市代碼+景點id"
 *
 */
public class Scenic implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer sid;
	private String ccode;
	private String cname;
	private String tcode;
	private String tname;
	private Integer tpriority;
	private String scenic;
	private String unesco;
	private Integer sticket;
	private String stime;
	private String highlights;
	private String scenicWiki;
	private Integer spriority;
	private String scode;
	private Double hotelWeights;
	private Double busWeights;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTcode() {
		return tcode;
	}

	public void setTcode(String tcode) {
		this.tcode = tcode;
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

	public String getUnesco() {
		return unesco;
	}

	public void setUnesco(String unesco) {
		this.unesco = unesco;
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

	public String getHighlights() {
		return highlights;
	}

	public void setHighlights(String highlights) {
		this.highlights = highlights;
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
	
	public Double getBusWeights() {
		return busWeights;
	}
	
	public void setBusWeights(Double busWeights) {
		this.busWeights = busWeights;
	}
	
	public Double getHotelWeights() {
		return hotelWeights;
	}
	
	public void setHotelWeights(Double hotelWeights) {
		this.hotelWeights = hotelWeights;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
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
		Scenic other = (Scenic) obj;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Scenic [sid=" + sid + ", ccode=" + ccode + ", cname=" + cname + ", tcode=" + tcode + ", tname=" + tname
				+ ", tpriority=" + tpriority + ", scenic=" + scenic + ", unesco=" + unesco + ", sticket=" + sticket
				+ ", stime=" + stime + ", highlights=" + highlights + ", scenicWiki=" + scenicWiki + ", spriority="
				+ spriority + ", scode=" + scode + ", hotelWeights=" + hotelWeights + ", busWeights=" + busWeights
				+ "]";
	}

}
