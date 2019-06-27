package com.suhas;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetVsLoad {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Smartphone.class);
    SessionFactory sf = configuration.buildSessionFactory();
    Session session1 = sf.openSession();
    session1.beginTransaction();
    // every time you use get(), you'll hit db
    // get() will give you the object
    Smartphone smartphone = session1.get(Smartphone.class, 101);
    System.out.println(smartphone);
    // but every time you use load(), you'll see query only if you use the result
    // load will give you proxy object
    Smartphone smartphone2 = session1.load(Smartphone.class, 101);
    System.out.println(smartphone2);
    session1.getTransaction().commit();
    
    // In terms of exception, get() gives null,load() will give you ObjectNotFound Exception

	}

}
