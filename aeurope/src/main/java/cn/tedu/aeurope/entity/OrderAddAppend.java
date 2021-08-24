package cn.tedu.aeurope.entity;

/**
 * 訂單追加備註
 */
public class OrderAddAppend extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Integer orderAddappendId;
	private Integer orderid;
	private String addAppend;

	public Integer getOrderAddappendId() {
		return orderAddappendId;
	}

	public void setOrderAddappendId(Integer orderAddappendId) {
		this.orderAddappendId = orderAddappendId;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getAddAppend() {
		return addAppend;
	}

	public void setAddAppend(String addAppend) {
		this.addAppend = addAppend;
	}

	@Override
	public String toString() {
		return "OrderAddAppend [orderAddappendId=" + orderAddappendId + ", orderid=" + orderid + ", addAppend="
				+ addAppend + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderAddappendId == null) ? 0 : orderAddappendId.hashCode());
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
		OrderAddAppend other = (OrderAddAppend) obj;
		if (orderAddappendId == null) {
			if (other.orderAddappendId != null)
				return false;
		} else if (!orderAddappendId.equals(other.orderAddappendId))
			return false;
		return true;
	}

}
