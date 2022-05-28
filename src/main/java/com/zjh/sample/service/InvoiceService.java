package com.zjh.sample.service;

import com.zjh.sample.dto.InvoiceDTO;
import com.zjh.sample.entity.Invoice;
import com.zjh.sample.repository.InvoiceRepository;
import com.zjh.sample.vo.InvoiceQueryVO;
import com.zjh.sample.vo.InvoiceUpdateVO;
import com.zjh.sample.vo.InvoiceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Integer save(InvoiceVO vO) {
        Invoice bean = new Invoice();
        BeanUtils.copyProperties(vO, bean);
        bean = invoiceRepository.save(bean);
        return bean.getInvoiceId();
    }

    public void delete(Integer id) {
        invoiceRepository.deleteById(id);
    }

    public void update(Integer id, InvoiceUpdateVO vO) {
        Invoice bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        invoiceRepository.save(bean);
    }

    public InvoiceDTO getById(Integer id) {
        Invoice original = requireOne(id);
        return toDTO(original);
    }

    public Page<InvoiceDTO> query(InvoiceQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private InvoiceDTO toDTO(Invoice original) {
        InvoiceDTO bean = new InvoiceDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Invoice requireOne(Integer id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
