package com.zjh.sample.service;

import com.zjh.sample.dto.InvoiceLineDTO;
import com.zjh.sample.entity.InvoiceLine;
import com.zjh.sample.repository.InvoiceLineRepository;
import com.zjh.sample.vo.InvoiceLineQueryVO;
import com.zjh.sample.vo.InvoiceLineUpdateVO;
import com.zjh.sample.vo.InvoiceLineVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class InvoiceLineService {

    @Autowired
    private InvoiceLineRepository invoiceLineRepository;

    public Integer save(InvoiceLineVO vO) {
        InvoiceLine bean = new InvoiceLine();
        BeanUtils.copyProperties(vO, bean);
        bean = invoiceLineRepository.save(bean);
        return bean.getInvoiceLineId();
    }

    public void delete(Integer id) {
        invoiceLineRepository.deleteById(id);
    }

    public void update(Integer id, InvoiceLineUpdateVO vO) {
        InvoiceLine bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        invoiceLineRepository.save(bean);
    }

    public InvoiceLineDTO getById(Integer id) {
        InvoiceLine original = requireOne(id);
        return toDTO(original);
    }

    public Page<InvoiceLineDTO> query(InvoiceLineQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private InvoiceLineDTO toDTO(InvoiceLine original) {
        InvoiceLineDTO bean = new InvoiceLineDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private InvoiceLine requireOne(Integer id) {
        return invoiceLineRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
