package com.zjh.sample.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "EmployeeId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "Title")
    private String title;

    @Column(name = "ReportsTo")
    private Integer reportsTo;

    @Column(name = "BirthDate")
    private Date birthDate;

    @Column(name = "HireDate")
    private Date hireDate;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Country")
    private String country;

    @Column(name = "PostalCode")
    private String postalCode;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Fax")
    private String fax;

    @Column(name = "Email")
    private String email;

}
