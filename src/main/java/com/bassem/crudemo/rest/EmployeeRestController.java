package com.bassem.crudemo.rest;


import com.bassem.crudemo.dao.EmployeeDAO;
import com.bassem.crudemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    //quick and dirty: inject employee dao

    @Autowired
    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
    employeeDAO = theEmployeeDAO;
}

    //expose "/employees" and return list employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
    return employeeDAO.findAll();
    }
}
