package com.suhas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    
        Configuration configuration = new Configuration();
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        session.save(alien);
    }
}
