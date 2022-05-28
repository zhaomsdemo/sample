package com.zjh.sample.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Data
@ApiModel("Save ")
public class EmployeeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "employeeId can not null")
    private Integer employeeId;

    @NotNull(message = "lastName can not null")
    private String lastName;

    @NotNull(message = "firstName can not null")
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
