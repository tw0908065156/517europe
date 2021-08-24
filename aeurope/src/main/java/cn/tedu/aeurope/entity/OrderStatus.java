package cn.tedu.aeurope.entity;

import java.io.Serializable;
	/**
	 * 訂單狀態描述
	 */
public class OrderStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer orderStatusId;
	private Integer orderStatus;
	private String orderStatusDesc;
	public Integer getOrderStatusId() {
		return orderStatusId;
	}
	public void setOrderStatusId(Integer orderStatusId) {
		this.orderStatusId = orderStatusId;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderStatusDesc() {
		return orderStatusDesc;
	}
	public void setOrderStatusDesc(String orderStatusDesc) {
		this.orderStatusDesc = orderStatusDesc;
	}
	@Override
	public String toString() {
		return "OrderStatus [orderStatusId=" + orderStatusId + ", orderStatus=" + orderStatus + ", orderStatusDesc="
				+ orderStatusDesc + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderStatusId == null) ? 0 : orderStatusId.hashCode());
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
		OrderStatus other = (OrderStatus) obj;
		if (orderStatusId == null) {
			if (other.orderStatusId != null)
				return false;
		} else if (!orderStatusId.equals(other.orderStatusId))
			return false;
		return true;
	}

}
