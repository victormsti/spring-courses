package com.luv2code.demo;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class PrimaryKeyDemo {

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
					// create 3 student objects
					System.out.println("Creating new student object...");
					Student tempStudent1 = new Student("Victor", "Silva", "teste@teste.com");
					Student tempStudent2 = new Student("João", "José", "teste2@teste.com");
					Student tempStudent3 = new Student("Maria", "Nazaré", "teste3@teste.com");
					
					ArrayList<Student> students = new ArrayList<>();
					students.add(tempStudent1);
					students.add(tempStudent2);
					students.add(tempStudent3);

					
					// start a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving the student...");
//					session.save(students);
//					session.save(tempStudent1);
//					session.save(tempStudent2);
//					session.save(tempStudent3);
					
					for (Student student : students) {
						session.save(student);
					}
					
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				
				finally {
					factory.close();
				}
			}
}