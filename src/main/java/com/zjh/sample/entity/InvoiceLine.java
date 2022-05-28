package com.zjh.sample.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "InvoiceLine")
public class InvoiceLine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "InvoiceLineId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceLineId;

    @Column(name = "InvoiceId", nullable = false)
    private Integer invoiceId;

    @Column(name = "TrackId", nullable = false)
    private Integer trackId;

    @Column(name = "UnitPrice", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

}
