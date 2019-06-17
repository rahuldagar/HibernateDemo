package com.suhas;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien alien  = new Alien();
        alien.setName("alexsky");
        alien.setTech("java");
        
        // agenda : save(alien);
        // save belongs to Session interface in hibernate
        // To instantiate Session object, we need to class which implements session, so we use SessionFactory
        // But, Again, SessionFactory is an Interface, check for class which implements
        // Configuration is the class which implements SessionFactory
    
        // .configure() to make use of 'hibernate.cfg.xml', .addAnnotatedClass() to specify which entity you are working with
        // Exception: No identifier specified for entity: com.suhas.Alien : No primary key mentioned in alien class
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        
        // since 'buildSessionFactory' is deprecated, use this:
        // ServiceRegistry reg = new ServiceRegistryBuilder().apply(configuration.getProperties()).buildServiceRegistry();
        // SessionFactory sf = configuration.buildSessionFactory(reg);
        
        // to save data, u need to follow ACID properties : Atomicity, Consistency, Isolation & Durability
        Transaction tx = session.beginTransaction();
        session.save(alien);
        tx.commit();
    }
}
