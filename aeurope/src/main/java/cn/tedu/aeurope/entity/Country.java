package cn.tedu.aeurope.entity;

import java.io.Serializable;

/**
 * "國家"資料明細表
 */
public class Country implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer cid;
	private String ccode;
	private String cname;
	private Integer cpriority;
	private String countryImage;	

	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
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
	public Integer getCpriority() {
		return cpriority;
	}
	public void setCpriority(Integer cpriority) {
		this.cpriority = cpriority;
	}
	public String getCountry_image() {
		return countryImage;
	}
	public void setCountry_image(String country_image) {
		this.countryImage = country_image;
	}

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", ccode=" + ccode + ", cname=" + cname + ", cpriority=" + cpriority
				+ ", country_image=" + countryImage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
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
		Country other = (Country) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		return true;
	}

}
