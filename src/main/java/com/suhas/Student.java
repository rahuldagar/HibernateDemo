package com.suhas;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	private int rollno;
	private String name;
	private int marks;
	// One student will have many laptops
	@ManyToMany(mappedBy = "students")
	private List<Laptop> Laptops = new ArrayList<>();

	public List<Laptop> getLaptops() {
		return Laptops;
	}

	public void setLaptops(List<Laptop> laptops) {
		Laptops = laptops;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", nameString=" + name  + ", marks=" + marks + "]";
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
}
