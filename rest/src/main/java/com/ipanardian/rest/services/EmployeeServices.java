package com.ipanardian.rest.services;

import java.util.List;

import com.ipanardian.rest.models.Employee;
import com.ipanardian.rest.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmployeeServices
 */
@Service("employeeServices")
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee findEmployeeByPosition(String position) {
        return employeeRepository.findByPosition(position);
    }
    
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee, Long id) {
        Employee updateEmployee = employeeRepository.findById(id).orElse(null);

        if (updateEmployee != null) {
            updateEmployee.setName(employee.getName());
            updateEmployee.setPosition(employee.getPosition());
        }

        final Employee savedEmployee = employeeRepository.save(updateEmployee);
        return savedEmployee;
    }

    public Boolean deleteEmployee(Long id) {
        Employee delEmployee = employeeRepository.findById(id).orElse(null);

        if (delEmployee != null) {
            employeeRepository.delete(delEmployee);
            return true;
        }

        return false;
    }
}