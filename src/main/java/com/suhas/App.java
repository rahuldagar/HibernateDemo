package com.suhas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    		Alien alien  = new Alien();
    		alien.setTech("C++");
    		alien.setAid(101);
        alien.setName("John Doe");
        
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(alien);
        tx.commit();
    }
}
