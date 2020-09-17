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
	
	@Override 
	public int hashCode() {
		final int prime = 5;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : Long.hashCode(id));
		result = prime * result + ((oid == null) ? 0 : Long.hashCode(oid));
		result = prime * result + ((iid == null) ? 0 : Long.hashCode(iid));
		result = prime * result + ((cost == null) ? 0 : Double.hashCode(cost));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		CompoundOrderItem other = (CompoundOrderItem) obj;
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
		if (getCost() == null) {
			if (other.getCost() != null)
				return false;
		} else if (!cost.equals(other.getCost()))
			return false;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.contentEquals(other.getName()))
			return false;
		return true;
	}
}
