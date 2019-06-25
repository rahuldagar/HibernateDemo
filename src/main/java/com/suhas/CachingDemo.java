package com.suhas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CachingDemo {
	public static void main(String args[]) {
		Alien alien = null;
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
    SessionFactory sf = configuration.buildSessionFactory();
    Session session1 = sf.openSession();
    session1.beginTransaction();
    
    alien = (Alien) session1.get(Alien.class, 101);
    System.out.println(alien);

    alien = (Alien) session1.get(Alien.class, 101);
    System.out.println(alien);

    // Notice that only one query is done in logs
    // when above two queries are executed, hibernate first checks whether the value is
    // there in first level and second level cache, if its not there, then it will fetch from db

    session1.getTransaction().commit();
    
	}
}
