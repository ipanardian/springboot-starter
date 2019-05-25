package com.ipanardian.rest.services;

import java.util.ArrayList;
import java.util.List;

import com.ipanardian.rest.models.Employee;
import com.ipanardian.rest.utils.ResponseWrapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeController
 */
@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public ResponseEntity<ResponseWrapper<List<Employee>>> listEmployee() {
        List<Employee> list = new ArrayList<Employee>();

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Ipan Ardian");
        employee.setPosition("VP Engineer");
        list.add(employee);

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Tony Stark");
        employee2.setPosition("Java Developer");
        list.add(employee2);

        ResponseWrapper<List<Employee>> response = new ResponseWrapper<List<Employee>>();
        response.setResult(list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping("/employees")
    public ResponseEntity<ResponseWrapper<Employee>> createEmployee(@RequestBody Employee employee) {
		ResponseWrapper<Employee> response = new ResponseWrapper<Employee>();
        response.setResult(employee);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}