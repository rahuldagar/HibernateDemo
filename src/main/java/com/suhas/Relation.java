package com.suhas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Relation {
	public static void main(String args[]) {
		
		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setLname("Dell");
		
		Laptop laptop2 = new Laptop();
		laptop2.setLid(102);
		laptop2.setLname("macbook");
		
		Student student = new Student();
		student.setName("Suhas");
		student.setRollno(1);
		student.setMarks(50);
		student.getLaptops().add(laptop);
		student.getLaptops().add(laptop2);
		
		//laptop.getStudents().add(student);
		
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		
		SessionFactory sf = configuration.buildSessionFactory();
    Session session = sf.openSession();
    Transaction tx = session.beginTransaction();
    session.save(laptop);
    session.save(student);
    tx.commit();
    
    /*
     mysql> show tables;
			+----------------------------+
			| Tables_in_jsp_servlet_demo |
			+----------------------------+
			| alien                      |
			| Laptop                     |
			| Laptop_Student             |
			| Student                    |
			+----------------------------+
			4 rows in set (0.00 sec)
			
			mysql> select * from  laptop_student;
			+-------------+-----------------+
			| Laptops_lid | students_rollno |
			+-------------+-----------------+
			|         101 |               1 |
			+-------------+-----------------+
    */
	}
}
