package com.suhas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "alien")
public class Alien {
	@Id
	private int Alienid;
	// private String name; // incase it has first name, middle name and last name, we are creating one more class : AlienName.java
	private AlienName fullName;
	private String tech;
	
	@Override
	public String toString() {
		return "Alien [Alienid=" + Alienid + ", fullName=" + fullName + ", tech=" + tech + "]";
	}

	public int getAlienid() {
		return Alienid;
	}
	
	public void setAlienid(int alienid) {
		Alienid = alienid;
	}
	
	public AlienName getFullName() {
		return fullName;
	}

	public void setFullName(AlienName fullName) {
		this.fullName = fullName;
	}

	public String getTech() {
		return tech;
	}
	
	public void setTech(String tech) {
		this.tech = tech;
	}
	
}
