package cn.tedu.aeurope.entity;

/**
 * 購物車明細表
 */
public class ScenicCart extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Integer cartid;
	private Integer clientId;
	private String clientEmail;
	private Integer sid;
	private String scode;

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
		ScenicCart other = (ScenicCart) obj;
		if (cartid == null) {
			if (other.cartid != null)
				return false;
		} else if (!cartid.equals(other.cartid))
			return false;
		return true;
	}


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

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "ScenicCart [cartid=" + cartid + ", clientId=" + clientId + ", clientEmail=" + clientEmail + ", sid="
				+ sid + ", scode=" + scode + "]";
	}

}
