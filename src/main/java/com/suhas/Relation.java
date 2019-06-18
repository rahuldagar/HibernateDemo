package com.suhas;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Relation {
	public static void main(String args[]) {
		
		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setLname("Dell");
		
		Student student = new Student();
		student.setName("Suhas");
		student.setRollno(1);
		student.setMarks(50);
		student.setLaptop(laptop);
		
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		
		SessionFactory sf = configuration.buildSessionFactory();
    Session session = sf.openSession();
    Transaction tx = session.beginTransaction();
    session.save(laptop);
    session.save(student);
    tx.commit();
    
    /*
     mysql> select * from student;
		+--------+-------+-------+------------+
		| rollno | marks | name  | Laptop_lid |
		+--------+-------+-------+------------+
		|      1 |    50 | Suhas |        101 |
		+--------+-------+-------+------------+ 
    */
	}
}
