package com.suhas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

// @Entity(name="alien_table") if you want your database table name to be "alien_table", 
// also this should be supported by <property name="hbm2ddl.auto">create</property> in hibernate.cfg.xml 

/*
 Three layers of entity are there:
 1. class Name
 2. Entity name
 3. Table name
 
 If we want to change only table name, 
 @Table(name="alien_table")
 
 Table and Entity both are different
 */
@Entity
public class Alien {
	@Id
	private int Alienid;
	// @Transient
	// means, name will not be getting stored in database, there will be no column in db
	private String name;
	//@Column(name = "alien_tech")
	// alien_tech will be column in database
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
