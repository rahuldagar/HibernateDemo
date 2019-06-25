package com.suhas;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GraduateFactory {
	public static void main(String args[]) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Graduate.class);
    SessionFactory sf = configuration.buildSessionFactory();
    Session session = sf.openSession();
    Random random = new Random();
    
    session.beginTransaction();
    
    for (int i = 0; i < 50; i++) {
			Graduate graduate = new Graduate();
			graduate.setRollno(i);
			graduate.setName("name-"+i);
			graduate.setMarks(i + random.nextInt(50));
			session.save(graduate);
		}
    
    session.getTransaction().commit();
	}
}
