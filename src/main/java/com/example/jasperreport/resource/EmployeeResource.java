package com.example.jasperreport.resource;

import com.example.jasperreport.jpa.entity.Employee;
import com.example.jasperreport.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeResource {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

}
