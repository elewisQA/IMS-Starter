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
		//TODO fill this out - matching structure of customer.equals() method
		return false;
	}
}
