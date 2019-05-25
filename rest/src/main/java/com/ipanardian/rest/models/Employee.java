package com.ipanardian.rest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;


/**
 * Employee
 */
@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "* Please enter full name")
    private String name;

    @Column(name = "position")
    @NotEmpty(message = "* Please enter job position")
    private String position;
}