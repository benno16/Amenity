package com.amenity.workbench.supporter.classes;

import java.util.Date;

public class ContainerClass {
	
	private String name;
	private String description;
	private Date created;
	private Date lastUsed;
	
	public ContainerClass () {
		
	}
	
	public ContainerClass ( String name ) {
		this.name = name;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getLastUsed() {
		return lastUsed;
	}
	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}
	

}
