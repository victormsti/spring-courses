package com.luv2code.demo;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try {
			
			int studentId = 2;
			
			// create session
			Session session = factory.getCurrentSession();
			
			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			
//			// delete the student
//			System.out.println("Deleting student: " + myStudent);
//			session.delete(myStudent);
			
			// delete the student with id = 3
			System.out.println("Deleting student id=3");
			session.createQuery("delete from Student where id=3").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("\nDone!");
			
		}
		
		finally {
			factory.close();
		}
	}

}
