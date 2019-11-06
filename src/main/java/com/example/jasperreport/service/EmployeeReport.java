package com.example.jasperreport.service;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface EmployeeReport {

    public String employeeReport(String format) throws FileNotFoundException, JRException;
}
