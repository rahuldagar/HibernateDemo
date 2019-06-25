package com.suhas;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// NOTE: Before running this class, run GraduateFactory.java to generate data

public class HqlDemo {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Graduate.class);
    SessionFactory sf = configuration.buildSessionFactory();
    Session session = sf.openSession();
    
    session.beginTransaction();
    
    // observer Graduate in query, its in caps, It represents a class
    Query query = session.createQuery("from Graduate where marks > 50");
    List<Graduate> graduateList = query.list();
    
    Query query2 = session.createQuery("from Graduate where rollno = 7");
    Graduate g = (Graduate)query2.uniqueResult();

    // this will not work : you'll get array of string
    Query query3 = session.createQuery("select rollno, name from Graduate where rollno = 7");
    Graduate g2 = (Graduate)query3.uniqueResult();
    
    for (Graduate graduate : graduateList) {
			System.out.println(graduate);
		}
    
    System.out.println(g);
    
    session.getTransaction().commit();
	}

}
