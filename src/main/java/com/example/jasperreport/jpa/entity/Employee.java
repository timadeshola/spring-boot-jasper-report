package com.example.jasperreport.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "employees")
@Setter
@Getter
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private BigDecimal salary;

    private Timestamp dateJoined;

}
