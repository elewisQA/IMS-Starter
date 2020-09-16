package com.qa.ims.persistence.domain;

public class CompoundOrderItem extends OrderItem {
	private String name;
	private Double cost;
	
	public CompoundOrderItem(Long id, Long oid, Long iid, String name, Double cost) {
		super(id, oid, iid);
		this.setName(name);
		this.setCost(cost);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getCost() {
		return cost;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		String toReturn = String.format("UID: %-3d | Item-ID: %-3d | Name: %-40s | Cost: £%-4.2f", this.id, this.iid, name, cost);
		return toReturn;
	}
}
