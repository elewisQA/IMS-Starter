package com.qa.ims.persistence.domain;

public class Order {
	
	private Long oid;
	private Long cid;
	private String address;
	private Boolean fulfilled;
	
	public Order(Long cid, String address, Boolean fulfilled) {
		this.setCid(cid);
		this.setAddress(address);
		this.setFulfilled(fulfilled);
	}
	
	public Order(Long oid, Long cid, String address, Boolean fulfilled) {
		this.setOid(oid);
		this.setCid(cid);
		this.setAddress(address);
		this.setFulfilled(fulfilled);
	}

	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	public Long getCid() {
		return cid;
	}
	
	public void setCid(Long cid) {
		this.cid = cid;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Boolean getFulfilled() {
		return fulfilled;
	}
	
	public void setFulfilled(Boolean fulfilled) {
		this.fulfilled = fulfilled;
	}
	
	@Override
	public String toString() {
		return "oid:" + oid + " cid:" + cid + " address:" + address + " fulfilled:" + fulfilled;
	}
	
	@Override
	public int hashCode() {
		final int prime = 7;
		int result = 1;
		result = prime * result + (oid.hashCode());
		result = prime * result + (cid.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (fulfilled.hashCode());
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
		Order other = (Order) obj;
		if (getCid() == null) 
			if (other.getCid() != null)
				return false;
		if (getOid() == null)
			if (other.getOid() != null)
				return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (fulfilled == other.getFulfilled())
			return true;
		return true;
	}
}
