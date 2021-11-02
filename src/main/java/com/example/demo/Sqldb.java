package com.example.demo;

import java.io.Serializable;

public class Sqldb implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -673463042786552023L;
	/**
	 * 
	 */
	
	String user;
	String pswd;
	
	protected Sqldb(String user, String pswd) {
		super();
		this.user = user;
		this.pswd = pswd;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	@Override
	public String toString() {
		return "Sqldb [user=" + user + ", pswd=" + pswd + "]";
	}
	

}
