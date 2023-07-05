package model;

import java.io.Serializable;

public class User implements Serializable{
	private String userId;
	private String pass;
	
	public User(String userId,String pass) {
		this.userId = userId;
		this.pass = pass;
	}

	public String getUserId() {return userId;}
	public void setUserId(String userId) {this.userId = userId;}
	
	public String getPassword() {return pass;}
	public void setPassword(String password) {this.pass = password;}
	
}
