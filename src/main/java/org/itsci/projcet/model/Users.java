package org.itsci.projcet.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class Users {
	@Id
	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String fullname;

	@Column(nullable = false)
	private String role;
	
	public Users() {
		super();
	}
		
	public Users(String fullname, Room room) {
		super();
		this.fullname = fullname;
	}

	public String getFullname() {
		return fullname;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
