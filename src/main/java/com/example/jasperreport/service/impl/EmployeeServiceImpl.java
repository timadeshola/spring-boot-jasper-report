package com.example.jasperreport.service.impl;

import com.example.jasperreport.jpa.entity.Employee;
import com.example.jasperreport.jpa.repository.EmployeeRepository;
import com.example.jasperreport.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
