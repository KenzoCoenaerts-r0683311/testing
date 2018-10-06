package org.ucll.demo.domain;

public enum Role {
	ADMIN("admin"), CARETAKER("caretaker"), PATIENT("patient");

	private String description;

	Role(String description) {
		this.description = description;
	}
	
	Role() {
		
	}

	public String getDescription() {
		return description;
	}
}
