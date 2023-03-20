package com.user;

public class RegisterUser {
	public String name;
	public String Username;
	public String Password;
	
	
	public RegisterUser(String name, String username, String password) {
		super();
		this.name = name;
		Username = username;
		Password = password;
	
	
	
	}


	@Override
	public String toString() {
		return "ResisterUser [name=" + name + ", Username=" + Username + ", Password=" + Password + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	} 




}
