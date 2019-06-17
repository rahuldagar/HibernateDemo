package com.suhas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		Alien alien = null;
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);
		SessionFactory sf = configuration.buildSessionFactory();
    Session session = sf.openSession();
    Transaction tx = session.beginTransaction();
    tx.commit();
		alien =(Alien)session.get(Alien.class, 7); // Fetching by id
		System.out.println(alien);
	}

}
