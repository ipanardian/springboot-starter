package com.ipanardian.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import com.ipanardian.rest.models.Employee;
import com.ipanardian.rest.services.EmployeeServices;
import com.ipanardian.rest.utils.ResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeController
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/employees")
    public ResponseEntity<ResponseWrapper<List<Employee>>> listEmployee() {
        List<Employee> listEmployee = employeeServices.getAllEmployee();
        ResponseWrapper<List<Employee>> response = new ResponseWrapper<List<Employee>>();
        response.setResult(listEmployee);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping("/employees")
    public ResponseEntity<ResponseWrapper<Employee>> createEmployee(@Valid @RequestBody Employee employee) {
		ResponseWrapper<Employee> response = new ResponseWrapper<Employee>();
        response.setResult(employeeServices.saveEmployee(employee));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<ResponseWrapper<Employee>> updateEmployee(@Valid @RequestBody Employee employee, 
        @PathVariable(value = "id") Long id) {
        
        ResponseWrapper<Employee> response = new ResponseWrapper<Employee>();
        response.setResult(employeeServices.updateEmployee(employee, id));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<ResponseWrapper<Employee>> deleteEmployee(@PathVariable Long id) {
        ResponseWrapper<Employee> response = new ResponseWrapper<>();

        Employee employee = employeeServices.findEmployeeById(id);
        if (employee == null) {
            response.setCode(404);
            response.setMessage("Employee not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.setResult(employee);

        if (employeeServices.deleteEmployee(id)) {
            response.setMessage("Employee deleted successfully");
            
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setCode(422);
            response.setMessage("Failed to delete employee with ID:"+id);

            return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}