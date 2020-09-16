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
		return "uuid: " + id + " | oid:" + oid + " | iid:" + id;
	}
	
	@Override 
	public int hashCode() {
		final int prime = 5;
		int result = 1;
		result = prime * result + (id.hashCode());
		result = prime * result + (oid.hashCode());
		result = prime * result + (iid.hashCode());
		return result;
		//TODO set these to == null ? methods
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
		if (getId() == null)
			if (other.getId() != null) 
				return false;
		return true;
	}
}
