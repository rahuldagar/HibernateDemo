package com.suhas;

import javax.persistence.Embeddable;

@Embeddable
public class AlienName {
	// you use @Embeddable annotation to embed your object inside another table
	private String fname;
	private String mname;
	private String lname;
	
	@Override
	public String toString() {
		return "AlienName [fname=" + fname + ", mname=" + mname + ", lname=" + lname + "]";
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
}
