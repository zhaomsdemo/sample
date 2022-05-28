package com.zjh.sample.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("")
public class EmployeeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer employeeId;

    private String lastName;

    private String firstName;

    private String title;

    private Integer reportsTo;

    private Date birthDate;

    private Date hireDate;

    private String address;

    private String city;

    private String state;

    private String country;

    private String postalCode;

    private String phone;

    private String fax;

    private String email;

}
