package cn.tedu.aeurope.entity;
	/**
	 * 訂單表~反饋及補充備註
	 */
public class OrderFeedback extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Integer orderFeedbackId;
	private Integer orderid;
	private String feedbackName;
	private String feedbackPdf;
	private String addAppend;
	
	public Integer getOrderFeedbackId() {
		return orderFeedbackId;
	}
	public void setOrderFeedbackId(Integer orderFeedbackId) {
		this.orderFeedbackId = orderFeedbackId;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getFeedbackName() {
		return feedbackName;
	}
	public void setFeedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
	}
	public String getFeedbackPdf() {
		return feedbackPdf;
	}
	public void setFeedbackPdf(String feedbackPdf) {
		this.feedbackPdf = feedbackPdf;
	}
	public String getAddAppend() {
		return addAppend;
	}
	public void setAddAppend(String addAppend) {
		this.addAppend = addAppend;
	}
	@Override
	public String toString() {
		return "OrderFeedback [orderFeedbackId=" + orderFeedbackId + ", orderid=" + orderid + ", feedbackName="
				+ feedbackName + ", feedbackPdf=" + feedbackPdf + ", addAppend=" + addAppend + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderFeedbackId == null) ? 0 : orderFeedbackId.hashCode());
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
		OrderFeedback other = (OrderFeedback) obj;
		if (orderFeedbackId == null) {
			if (other.orderFeedbackId != null)
				return false;
		} else if (!orderFeedbackId.equals(other.orderFeedbackId))
			return false;
		return true;
	}


}
