package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.luv2code.springdemo.entity.Student;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	// define @PostConstruct to load the student data ... only once!

		private List<Student> theStudents;

		@PostConstruct
		public void loadData() {
			theStudents = new ArrayList<>();

			theStudents.add(new Student("Victor", "Silva"));
			theStudents.add(new Student("Test2", "LastName2"));
			theStudents.add(new Student("Test3", "LastName3"));
		}

		// define endpoint for "/students" - return list of students
		@GetMapping("/students")
		public List<Student> getStudents() {

			return theStudents;
		}

		// define endpoint for "/students/{studentId}" - return student at index
		@GetMapping("/students/{studentId}")
		public Student getStudent(@PathVariable int studentId) {

			// check the studentId against list size
			if ((studentId >= theStudents.size() || studentId < 0)) {
				throw new StudentNotFoundException("Student id not found - " + studentId);
			}

			return theStudents.get(studentId);
		}

		// add an exception handler using @ExceptionHandler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

			// create a StudentErrorResponse
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());

			// return ResponseEntity
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
		// add another exception handler ... to catch ANY exception (catch all)
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

			// create a StudentErrorResponse
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.BAD_GATEWAY.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());

			// return ResponseEntity
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
}
