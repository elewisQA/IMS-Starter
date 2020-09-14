package com.qa.ims.persistence.domain;

public class Item {
	
	private Long id;
	private String name;
	private String description;
	
	public Item(String name, String description) {
		this.setName(name);
		this.setDescription(description);
	}
	
	public Item(Long id, String name, String description) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
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
	
	@Override
	public String toString() {
		return "id:" + id + " name:" + name + " description:" + description;
	}
	
	@Override
	public int hashCode() {
		final int prime = 7;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		} else if (!id.equals(other.id))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
}
