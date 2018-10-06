package org.ucll.demo.domain;

public class BmiUser {
	private String userid;
	private String password;
	private Role role;

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isCorrectPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		return getPassword().equals(password);
	}
}
