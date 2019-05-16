package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		// start a transaction
		session.beginTransaction();
		
		// use the session object to save Java object
		try {
			int theId = 1;
			// get the instructor from db
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor: " + tempInstructor);
			
			// get courses for the instructor
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		
		finally {
			//add clean up code
			
			session.close();
			factory.close();
		}
	}

}
