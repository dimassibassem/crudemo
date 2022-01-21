package com.bassem.crudemo.dao;

import com.bassem.crudemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
   public List<Employee> findAll();
}
