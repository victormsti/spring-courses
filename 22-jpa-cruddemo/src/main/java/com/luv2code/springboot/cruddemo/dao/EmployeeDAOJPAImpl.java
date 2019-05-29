package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	// automatic created by spring boot
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// create a query
		Query theQuery = entityManager.createQuery("from Employee");

		// execute the query
		List<Employee> employees = theQuery.getResultList();

		// return the results;
		return employees;
	}

	@Override
	public Employee findByYd(int theId) {

		Employee theEmployee = entityManager.find(Employee.class, theId);

		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		Employee dbEmployee = entityManager.merge(theEmployee);

		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void delete(int theId) {

		Query theQuery = entityManager.createQuery("delete from Employee where id = :theId");

		theQuery.setParameter("theId", theId);

		theQuery.executeUpdate();
	}
}
