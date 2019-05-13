package com.luv2code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		// use the session object to save Java object
		try {
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName = 'Silva'
			theStudents = session.createQuery("from Student s where s.lastName = 'Silva'").getResultList();
			System.out.println("\n\nStudents who have last name of Silva");
			displayStudents(theStudents);
			
			// query students: lastName = 'Silva' OR firstName = 'João'
			System.out.println("\n\nStudents who have last name of Silva or OR first name = João");
			theStudents = session.createQuery("from Student s where s.lastName = 'Silva' OR s.firstName = 'João'").getResultList();
			displayStudents(theStudents);

			// query students: where email LIKE '%luv2code@test.com'
			System.out.println("\n\nStudents who email LIKE '%luv2code@test.com\n");
			theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code@test.com'").getResultList();
			displayStudents(theStudents);
			
			System.out.println("Done!");
		}
		
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
