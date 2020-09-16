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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompoundOrder other = (CompoundOrder) obj;
		if (getCid() == null) 
			if (other.getCid() != null)
				return false;
		if (getOid() == null)
			if (other.getOid() != null)
				return false;
		if (cost == null) {
			if (other.getCost() != null)
				return false;
		} else if (cost.equals(other.getCost())) {
			return false;
		}
		if (address == null) {
			if (other.getAddress() != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (fulfilled == other.getFulfilled())
			return true;
		return true;
	}
}
