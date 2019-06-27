package com.suhas;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObjectStatesDemo {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Smartphone.class);
    SessionFactory sf = configuration.buildSessionFactory();
    Random random = new Random();
    
    Session session1 = sf.openSession();
    session1.beginTransaction();
    Smartphone smartphone = new Smartphone();
    smartphone.setPid(random.nextInt(999));
    smartphone.setBrand("Brand no "+ random.nextInt(500));
    smartphone.setPrice(random.nextInt(25000));
    // until here it will be in transient state
    session1.save(smartphone); // Now object will into persistant state
    smartphone.setPrice(10000); // even after save, it will be in persistance state, so new value will reflect in db
    smartphone.setPrice(9000);
    
    // for removed state
    session1.remove(smartphone);
    
    session1.getTransaction().commit();
    // for discontinuing persistance state, use detach:
    session1.detach(smartphone);
    smartphone.setPrice(600);
    
	}

}
