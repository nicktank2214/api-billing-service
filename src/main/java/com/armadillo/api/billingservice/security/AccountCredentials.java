package com.armadillo.api.billingservice.security;


/*
 * Notes
 * -----
 * 
 * We need just one extra class: the AccountCredentials class. 
 * This will be used to map request data when a POST call is made to /login path. 
 * The request data should contain the username and password as part of the body
 * 
 */
public class AccountCredentials {

	
	private String username;
	private String password;


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


}