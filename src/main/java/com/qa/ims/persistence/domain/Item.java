package com.qa.ims.persistence.domain;

public class Item {
	
	private Long id;
	private Double cost;
	private String name;
	private String description;
	
	public Item(String name, String description, Double cost) {
		this.setName(name);
		this.setDescription(description);
		this.setCost(cost);
	}
	
	public Item(Long id, String name, String description, Double cost) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		this.setCost(cost);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getCost() {
		return cost;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		String toReturn = String.format("Item-ID: %-3d | Name: %-20s | Description: %-40s | Cost: £%-4.2f", id, name, description, cost);
		return toReturn;
	}
	
	@Override
	public int hashCode() {
		final int prime = 7;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
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
		Item other = (Item) obj;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().contentEquals(other.getName())) {
			return false;
		}
		if (id == null) {
			if (other.id != null) 
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.getDescription()))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.getCost())) {
			return false;
		}
		return true;
	}
}
