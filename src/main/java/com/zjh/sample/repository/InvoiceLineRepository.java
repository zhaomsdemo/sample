package com.zjh.sample.repository;

import com.zjh.sample.entity.InvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, Integer>, JpaSpecificationExecutor<InvoiceLine> {

}