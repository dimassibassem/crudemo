package com.bassem.crudemo.dao;

import com.bassem.crudemo.entity.Employee;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    //define field for entitymanager
    private final EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        //execute a qurery and get result list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;

    }

    @Override
    public Employee findById(Integer id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the employree
        Employee theEmployee = currentSession.get(Employee.class, id);
        //return the employee
        return theEmployee;
    }

    @Override
    public void save(Employee employee) {
//get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // save employee
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(Integer id) {
//get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", id);
        theQuery.executeUpdate();
    }
}
