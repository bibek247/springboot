package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity
public class account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	 private Integer slno;
	 private String acctno;
	 private String firstname;
	 private Double mobileno;
	 
	 protected account(String acctno, String firstname, Double mobileno) {
		super();
		this.acctno = acctno;
		this.firstname = firstname;
		this.mobileno = mobileno;
	}
	
	
	 public Integer getSlno() {
		return slno;
	}
	public void setSlno(Integer slno) {
		this.slno = slno;
	}
	public String getAcctno() {
		return acctno;
	}
	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Double getMobileno() {
		return mobileno;
	}
	public void setMobileno(Double mobileno) {
		this.mobileno = mobileno;
	}


	@Override
	public String toString() {
		return "account [slno=" + slno + ", acctno=" + acctno + ", firstname=" + firstname + ", mobileno=" + mobileno
				+ "]";
	}
	
	 
}
