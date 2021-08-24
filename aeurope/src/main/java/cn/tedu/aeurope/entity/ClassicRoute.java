package cn.tedu.aeurope.entity;

import java.io.Serializable;
	/**
	 * 經典行程列表
	 */
public class ClassicRoute implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer routeid;
	private Integer caid;
	private String routeCode;
	private String routeName;
	private Integer rpriority;
	private String routeImage;
	private String routePdf;
	public Integer getRouteid() {
		return routeid;
	}
	public void setRouteid(Integer routeid) {
		this.routeid = routeid;
	}
	public Integer getCaid() {
		return caid;
	}
	public void setCaid(Integer caid) {
		this.caid = caid;
	}
	public String getRouteCode() {
		return routeCode;
	}
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public Integer getRpriority() {
		return rpriority;
	}
	public void setRpriority(Integer rpriority) {
		this.rpriority = rpriority;
	}
	public String getRouteImage() {
		return routeImage;
	}
	public void setRouteImage(String routeImage) {
		this.routeImage = routeImage;
	}
	public String getRoutePdf() {
		return routePdf;
	}
	public void setRoutePdf(String routePdf) {
		this.routePdf = routePdf;
	}
	@Override
	public String toString() {
		return "ClassicRoute [routeid=" + routeid + ", caid=" + caid + ", routeCode=" + routeCode + ", routeName="
				+ routeName + ", rpriority=" + rpriority + ", routeImage=" + routeImage + ", routePdf=" + routePdf
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routeid == null) ? 0 : routeid.hashCode());
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
		ClassicRoute other = (ClassicRoute) obj;
		if (routeid == null) {
			if (other.routeid != null)
				return false;
		} else if (!routeid.equals(other.routeid))
			return false;
		return true;
	}

}
