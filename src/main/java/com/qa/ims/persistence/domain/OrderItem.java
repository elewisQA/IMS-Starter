package com.qa.ims.persistence.domain;

public class OrderItem {
	
	protected Long id, oid, iid;
	
	public OrderItem(Long oid, Long iid) {
		this.setOid(oid);
		this.setIid(iid);
	}
	
	public OrderItem(Long id, Long oid, Long iid) {
		this.setId(id);
		this.setOid(oid);
		this.setIid(iid);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "uuid: " + id + " | oid:" + oid + " | iid:" + iid;
	}
	
	@Override 
	public int hashCode() {
		final int prime = 5;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : Long.hashCode(id));
		result = prime * result + ((oid == null) ? 0 : Long.hashCode(oid));
		result = prime * result + ((iid == null) ? 0 : Long.hashCode(iid));
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
		if (getId() == null) {
			if (other.getId() != null) 
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		if (getOid() == null) {
			if (other.getOid() != null)
				return false;
		} else if (!oid.equals(other.getOid()))
				return false;
		if (getIid() == null) {
			if (other.getIid() != null) 
				return false;
		} else if (!iid.equals(other.getIid()))
			return false;
		return true;
	}
}
