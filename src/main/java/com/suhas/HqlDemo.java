package com.suhas;

import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// NOTE: Before running this class, run GraduateFactory.java to generate data

public class HqlDemo {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Graduate.class);
    SessionFactory sf = configuration.buildSessionFactory();
    Session session = sf.openSession();
    int cutoff = 60;
    
    session.beginTransaction();

    // Example 1
    Query query = session.createQuery("select rollno, name from Graduate where rollno = 7");
    // Graduate g2 = (Graduate)query3.uniqueResult(); this will not work
    Object[] graduate = (Object[]) query.uniqueResult();
    for (Object object : graduate) {
			System.out.println(object);
		}
    // second way of printing
    System.out.println("\n"+ "roll no: " +graduate[0] + ":" + graduate[1]);
    
    // Example 2
    Query query2 = session.createQuery("select rollno, name, marks from Graduate");
    List<Object[]> graduates = (List<Object[]>) query2.list();
    for (Object[] grad : graduates) {
    	System.out.println("roll no:" + grad[0] + ": " + grad[1] + ": marks : " + grad[2]);
		}
    
    // Example 3
    Query query3 = session.createQuery("select rollno, name, marks from Graduate g where g.marks>60");
    List<Object[]> gradCond = (List<Object[]>) query3.list();
    System.out.println("Marks greater than 60 : \n");
    for (Object[] grad : gradCond) {
    	System.out.println("roll no:" + grad[0] + ": " + grad[1] + ": marks : " + grad[2]);
		}
    
    // Example 4
    Query query4 = session.createQuery("select sum(marks) from Graduate g where g.marks>60");
    // int totalMarks = (int) query4.uniqueResult(); : does not work since long is returned
    long totalMarks = (long) query4.uniqueResult();
    System.out.println("Total marks : "+totalMarks);
    
    // Example 5
    Query query5 = session.createQuery("select sum(marks) from Graduate g where g.marks>" + cutoff);
    long totalMarksDynamic = (long) query5.uniqueResult();
    System.out.println("Total marks : "+totalMarksDynamic);
    
    // Example 6
    // Just like using preparedStatement in jdbc, we can do :parameterName
    Query query6 = session.createQuery("select sum(marks) from Graduate g where g.marks > :c" );
    query6.setParameter("c", cutoff);
    long totalMarksDynamic2 = (long) query5.uniqueResult();
    System.out.println("Total marks : "+totalMarksDynamic2);
    
    // Example 7
    // using native sql queries
    SQLQuery squery = session.createSQLQuery("select * from graduate where marks > 60");
    squery.addEntity(Graduate.class); // without this line, you'll be returned obj reference (hash values), also we get entire object
    List<Graduate> grads = squery.list(); 
    for (Graduate nativeGrad : grads) {
			System.out.println(nativeGrad);
		}
    
    // Example 8
    // using native sql queries
    SQLQuery squery1 = session.createSQLQuery("select name, marks from graduate where marks > 60");
    squery1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); // convert output into map format
    List gs = squery1.list(); 
    for (Object obj : gs) {
    	Map m = (Map)obj;
			System.out.println(m.get("name") + " : " + m.get("marks"));
		}
    
    session.getTransaction().commit();
	}

}
