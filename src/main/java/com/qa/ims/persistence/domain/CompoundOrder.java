package com.qa.ims.persistence.domain;

public class CompoundOrder extends Order{
	private Long oid, cid;
	private Double cost;
	private String address;
	private Boolean fulfilled;
	
	public CompoundOrder(Long oid, Long cid, Double cost, String address, Boolean fulfilled) {
		super(oid, cid, address, fulfilled);
		this.oid = oid;
		this.cid = cid;
		this.cost = cost;
		this.address = address;
		this.fulfilled = fulfilled;
	}
	
	@Override
	public String toString() {
		String toReturn = String.format("Order-ID: %-3d | Customer-ID: %-3d | Total Cost: £%-4.2f | Delivery Address: %-40s | Dispatched: %b", 
				oid, cid, cost, address, fulfilled);
		return toReturn;
	}
}
