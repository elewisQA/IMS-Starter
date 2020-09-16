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
		return "Order ID:" + oid 
				+ " Customer ID:" + cid 
				+ " Total-Order Cost:" + cost
				+ " Delivery Address:" + address 
				+ " Order Dispatched:" + fulfilled;
	}
}
