package com.zjh.sample.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query ")
public class CustomerQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer customerId;

    private String firstName;

    private String lastName;

    private String company;

    private String address;

    private String city;

    private String state;

    private String country;

    private String postalCode;

    private String phone;

    private String fax;

    private String email;

    private Integer supportRepId;

}
