package com.example.jasperreport.service.impl;

import com.example.jasperreport.jpa.entity.Employee;
import com.example.jasperreport.service.EmployeeReport;
import com.example.jasperreport.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.boot.system.SystemProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeReportImpl implements EmployeeReport {

    private final EmployeeService employeeService;

    static final String HTML = "html";
    static final String PDF = "pdf";
    static final String PATH = System.getProperty("user.home") + "/Downloads/";


    @Override
    public String employeeReport(String format) throws FileNotFoundException, JRException {

        List<Employee> employees = employeeService.findAll();

        //loaf file
        File file = ResourceUtils.getFile("classpath:reports/employees.jrxml");

        //compile file
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, null, dataSource);

        if (format.equalsIgnoreCase(HTML)) {
            JasperExportManager.exportReportToHtmlFile(print, PATH + "employees.html");
        } else if (format.equalsIgnoreCase(PDF)) {
            JasperExportManager.exportReportToPdfFile(print, PATH + "employees.pdf");
        }

        return "File generated successfully, please check " + PATH;

    }
}
