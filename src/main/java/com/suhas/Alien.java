package com.suhas;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
	@Id
	private int Alienid;
	private String name;
	private String tech;
	
	@Override
	public String toString() {
		return "Alien{" +
				"Alienid=" + Alienid +
				", name='" + name + '\'' +
				", tech='" + tech + '\'' +
				'}';
	}
	
	public int getAlienid() {
		return Alienid;
	}
	
	public void setAlienid(int alienid) {
		Alienid = alienid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTech() {
		return tech;
	}
	
	public void setTech(String tech) {
		this.tech = tech;
	}
	
}
