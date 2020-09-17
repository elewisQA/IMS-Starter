package com.qa.ims.persistence.domain;

public class CompoundOrder extends Order{
	private Double cost;
	
	public CompoundOrder(Long oid, Long cid, Double cost, String address, Boolean fulfilled) {
		super(oid, cid, address, fulfilled);
		this.cost = cost;
	}
	
	public CompoundOrder(Long oid, Long cid, String address, Boolean fulfilled) {
		super(oid, cid, address, fulfilled);
		this.cost = 0.0;
	}
	
	public CompoundOrder(Order order, Double cost) {
		super(order.getOid(), order.getCid(), order.getAddress(), order.getFulfilled());
		this.cost = cost;
	}
	
	public Double getCost() {
		return cost;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		String toReturn = String.format("Order-ID: %-3d | Customer-ID: %-3d | Total Cost: £%-4.2f | Delivery Address: %-40s | Dispatched: %b", 
				this.oid, this.cid, cost, this.address, this.fulfilled);
		return toReturn;
	}
	
	@Override 
	public int hashCode() {
		final int prime = 7;
		int result = 1;
		result = prime * result + ((oid == null) ? 0 : Long.hashCode(oid));
		result = prime * result + ((cid == null) ? 0 : Long.hashCode(cid));
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((fulfilled == null) ? 0 : Boolean.hashCode(fulfilled));
		result = prime * result + ((cost == null) ? 0 : Double.hashCode(cost));
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
		CompoundOrder other = (CompoundOrder) obj;
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
		// Compare cost
		if (getCost() == null) {
			if (other.getCost() != null)
				return false;
		} else if(!getCost().equals(other.getCost()))
			return false;
		return true;
	}
}
