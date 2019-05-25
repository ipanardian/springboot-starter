package com.ipanardian.rest.repositories;

import com.ipanardian.rest.models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository
 */
@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByPosition(String position);
}