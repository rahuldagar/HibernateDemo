package com.suhas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "alien")
public class Alien {
	@Id
	private int aid;
	private String name;
	private String tech;
	@OneToMany(mappedBy = "alien")
	private List<Laptop> laptops = new ArrayList<Laptop>();
	
	public List<Laptop> getLaptops() {
		return laptops;
	}
	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}
	@Override
	public String toString() {
		return "Alien [Alienid=" + aid + ", fullName=" + name + ", tech=" + tech + "]";
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
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
