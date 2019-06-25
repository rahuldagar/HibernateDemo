package com.suhas;

import java.util.List;

import javax.persistence.FetchType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EagerVsLazy {

	public static void main(String[] args) {
		Alien alien  = new Alien();
		alien.setTech("C++");
		alien.setAid(101);
    alien.setName("John Doe");
    
    Alien alien2 = new Alien();
    alien2.setTech("Java");
    alien2.setAid(102);
    alien2.setName("Lao Tsu");
    
    Laptop l1 = new Laptop();
    l1.setLid(111);
    l1.setLname("Dell");
    l1.setAlien(alien);
    
    Laptop l2 = new Laptop();
    l2.setLid(112);
    l2.setLname("Lenovo");
    l2.setAlien(alien2);
    
    Laptop l3 = new Laptop();
    l3.setLid(113);
    l3.setLname("HP");
    l3.setAlien(alien2);
    
    // if below three lines of code is not there, we need to fetch the data like this:
    // select laptop.lname from laptop inner join alien on laptop.alien_aid=alien.aid where alien.aid = 102;
    // for a1.fetLaptops();
    /*alien.getLaptops().add(l1);
    alien.getLaptops().add(l2);
    alien2.getLaptops().add(l3);*/
    
    Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
    SessionFactory sf = configuration.buildSessionFactory();
    Session session = sf.openSession();
    Transaction tx = session.beginTransaction();
    
    session.save(alien);
    session.save(alien2);
    session.save(l1);
    session.save(l2);
    session.save(l3);  
    
    Alien a1 = session.get(Alien.class, 101);
    // only when asked for, laptop query is triggered for alien
    // what if i want all laptops of alien object when i do get an alien like above line
    // do fetch = FetchType.EAGER in ALien.java for Eager Loading
    /*List<Laptop> a1Laptops = a1.getLaptops();
    for (Laptop laptop : a1Laptops) {
			System.out.println(laptop);
		}*/
    tx.commit();

	}

}
