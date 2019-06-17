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
    		// changes made in cfg file
    		/* <property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
      	<property name="hbm2ddl.auto">create</property> */
    	
    		Alien alien  = new Alien();
    		alien.setTech("C++");
    		alien.setAlienid(101);
    		
    		AlienName alienName = new AlienName();
    		alienName.setFname("Shiva");
    		alienName.setMname("Venkata");
    		alienName.setLname("Iyer");
    		
        alien.setFullName(alienName);
        
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(alien);
        tx.commit();
    }
}
