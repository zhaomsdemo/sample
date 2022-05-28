package com.zjh.sample.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class CustomerVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "customerId can not null")
    private Integer customerId;

    @NotNull(message = "firstName can not null")
    private String firstName;

    @NotNull(message = "lastName can not null")
    private String lastName;

    private String company;

    private String address;

    private String city;

    private String state;

    private String country;

    private String postalCode;

    private String phone;

    private String fax;

    @NotNull(message = "email can not null")
    private String email;

    private Integer supportRepId;

}
