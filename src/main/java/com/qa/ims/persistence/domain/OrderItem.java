package com.qa.ims.persistence.domain;

public class OrderItem {
	
	private Long oid;
	private Long iid;
	private Long qty;
	
	/*public OrderItem(Long cid, Long qty) {
		// TODO is this necessary?
		this.setIid(cid);
		this.setQty(qty);
	}*/
	
	public OrderItem(Long oid, Long iid, Long qty) {
		this.setOid(oid);
		this.setIid(iid);
		this.setQty(qty);
	}
	
	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	public Long getIid() {
		return iid;
	}
	
	public void setIid(Long iid) {
		this.iid = iid;
	}
	
	public Long getQty() {
		return qty;
	}
	
	public void setQty(Long qty) {
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		return "iid:" + iid + " qty:" + qty;
	}
	
	@Override 
	public int hashCode() {
		final int prime = 5;
		int result = 1;
		result = prime * result + (oid.hashCode());
		result = prime * result + (iid.hashCode());
		result = prime * result + (qty.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (getOid() == null) 
			if (other.getOid() != null)
				return false;
		if (getIid() == null) 
			if (other.getIid() != null) 
				return false;
		if (getQty() == null)
			if (other.getQty() != null) 
				return false;
		return true;
	}
}
