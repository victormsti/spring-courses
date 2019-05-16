package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			// create some courses
			Course tempcourse1 = new Course("Air guitar2");
			Course tempcourse2 = new Course("Football course2");
			Course tempcourse3 = new Course("The Pinball Masterclass2");
			
			// add courses to instructor
			tempInstructor.add(tempcourse1);
			tempInstructor.add(tempcourse2);
			tempInstructor.add(tempcourse3);
			
			// save the courses
			session.save(tempcourse1);
			session.save(tempcourse2);
			session.save(tempcourse3);
			
			
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
