package com.bassem.crudemo.rest;


import com.bassem.crudemo.entity.Employee;
import com.bassem.crudemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;


    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    //expose "/employees" and return list employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable Integer employeeId) {
        Employee TheEmployee = employeeService.findById(employeeId);
        if (TheEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return TheEmployee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead doing an update

        theEmployee.setId(0);

        employeeService.save(theEmployee);

        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee == null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;

    }
}
