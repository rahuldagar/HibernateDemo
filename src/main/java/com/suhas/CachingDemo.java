package com.suhas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CachingDemo {
	public static void main(String args[]) {
		Alien alien1 = null;
		Alien alien2 = null;
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
    SessionFactory sf = configuration.buildSessionFactory();
    
    Session session1 = sf.openSession();
    session1.beginTransaction();
    alien1 = (Alien) session1.get(Alien.class, 101);
    System.out.println(alien1);
    session1.getTransaction().commit();

    Session session2 = sf.openSession();
    session2.beginTransaction();
    alien2 = (Alien) session2.get(Alien.class, 101);
    System.out.println(alien2);
    session2.getTransaction().commit();
    
    // Now observer that two queries are fired for two different transactions
    // download dependencies from :
    // https://mvnrepository.com/artifact/org.hibernate/hibernate-ehcache/5.3.7.Final
    // https://mvnrepository.com/artifact/net.sf.ehcache/ehcache/2.10.4
    // <property name="hibernate.cache.use_second_level_cache">true</property> in hibernate.cfg.xml
    // make sure both hibernate version & hibernate-ehcache versions are same in dependency
    // add @Cache and @Cacheble in ALien.java
    
	}
}
