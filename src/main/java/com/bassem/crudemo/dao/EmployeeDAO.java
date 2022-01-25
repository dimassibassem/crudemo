package com.bassem.crudemo.dao;

import com.bassem.crudemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
   List<Employee> findAll();
   Employee findById(Integer id);
   void save(Employee employee);
   void deleteById(Integer id);
}
