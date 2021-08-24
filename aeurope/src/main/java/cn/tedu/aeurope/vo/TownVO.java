package cn.tedu.aeurope.vo;

import java.io.Serializable;
	/**
	 * 城市統計VO類
	 */
public class TownVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer townTempId;
	private String ctname;
	private String tnames;
	public Integer getTownTempId() {
		return townTempId;
	}
	public void setTownTempId(Integer townTempId) {
		this.townTempId = townTempId;
	}
	public String getCtname() {
		return ctname;
	}
	public void setCtname(String ctname) {
		this.ctname = ctname;
	}
	public String getTnames() {
		return tnames;
	}
	public void setTnames(String tnames) {
		this.tnames = tnames;
	}
	@Override
	public String toString() {
		return "TownTemp [townTempId=" + townTempId + ", ctname=" + ctname + ", tnames=" + tnames + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((townTempId == null) ? 0 : townTempId.hashCode());
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
		TownVO other = (TownVO) obj;
		if (townTempId == null) {
			if (other.townTempId != null)
				return false;
		} else if (!townTempId.equals(other.townTempId))
			return false;
		return true;
	}
	
}
