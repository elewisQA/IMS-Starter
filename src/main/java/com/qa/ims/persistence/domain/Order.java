package com.qa.ims.persistence.domain;

public class Order {
	
	protected Long oid;
	protected Long cid;
	protected String address;
	protected Boolean fulfilled;
	
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
		return "Order ID:" + oid + " Customer ID:" + cid + " Delivery Address:" + address + " Order Dispatched:" + fulfilled;
	}
	
	@Override
	public int hashCode() {
		final int prime = 7;
		int result = 1;
		result = prime * result + ((oid == null) ? 0 : Long.hashCode(oid));
		result = prime * result + ((cid == null) ? 0 : Long.hashCode(cid));
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((fulfilled == null) ? 0 : Boolean.hashCode(fulfilled));
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
		// Compare Order-ID
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid)) 
			return false;
		// Compare Customer-ID
		if (getCid() == null) {
			if (other.getCid() != null)
				return false;
		} else if (!getCid().equals(other.getCid())) 
			return false;
		// Compare Delivery Address
		if (getAddress() == null) {
			if (other.getAddress() != null)
				return false;
		} else if (!getAddress().equals(other.getAddress()))
			return false;
		// Compare fulfilment status
		if (getFulfilled() == null) {
			if (other.getFulfilled() != null)
				return false;
		} else if(!getFulfilled().equals(other.getFulfilled()))
			return false;
		return true;
	}
}
