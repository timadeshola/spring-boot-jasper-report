package com.example.jasperreport;

import com.example.jasperreport.jpa.entity.Employee;
import com.example.jasperreport.jpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JasperReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(JasperReportApplication.class, args);
    }

}

@Service
@RequiredArgsConstructor
class CustomCommandLineRunner implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        List<String> firstNames = Arrays.asList("John", "Mike", "Peter", "Bassey", "Nduka", "Paul", "Tayo", "Bola", "Mojisola", "Stanley");
        List<String> lastNames = Arrays.asList("Adeshola", "Ndukwe", "Anichebe", "Wale", "Isreal", "Adeolu", "Olawale", "Afam", "Idahosa", "Effiong");

        List<Employee> employees = new ArrayList<>();

        for (String firstName : firstNames) {
            Employee employee = new Employee();
            for (String lastName : lastNames) {
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setSalary(BigDecimal.valueOf(Long.parseLong(RandomStringUtils.randomNumeric(6))));
                employee.setDateJoined(new Timestamp(System.currentTimeMillis()));
            }
            employees.add(employee);
        }

        employeeRepository.saveAll(employees);

    }
}
