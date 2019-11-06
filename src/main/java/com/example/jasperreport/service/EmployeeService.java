package com.example.jasperreport.service;

import com.example.jasperreport.jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
