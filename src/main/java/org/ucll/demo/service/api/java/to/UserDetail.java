package org.ucll.demo.service.api.java.to;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetail {
	@NotNull(message="{error.no.valid.id}")
	@Size(min=1, message="{error.no.valid.id}")
	private String userid;
	@NotNull(message="{error.no.valid.password}")
	@Size(min=1, message="{error.no.valid.password}")
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public UserDetail(){
	}
	
}
