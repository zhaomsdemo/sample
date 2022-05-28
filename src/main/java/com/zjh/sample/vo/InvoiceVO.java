package com.zjh.sample.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@ApiModel("Save ")
public class InvoiceVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "invoiceId can not null")
    private Integer invoiceId;

    @NotNull(message = "customerId can not null")
    private Integer customerId;

    @NotNull(message = "invoiceDate can not null")
    private Date invoiceDate;

    private String billingAddress;

    private String billingCity;

    private String billingState;

    private String billingCountry;

    private String billingPostalCode;

    @NotNull(message = "total can not null")
    private BigDecimal total;

}
