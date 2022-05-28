package com.zjh.sample.service;

import com.zjh.sample.dto.CustomerDTO;
import com.zjh.sample.entity.Customer;
import com.zjh.sample.repository.CustomerRepository;
import com.zjh.sample.vo.CustomerQueryVO;
import com.zjh.sample.vo.CustomerUpdateVO;
import com.zjh.sample.vo.CustomerVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Integer save(CustomerVO vO) {
        Customer bean = new Customer();
        BeanUtils.copyProperties(vO, bean);
        bean = customerRepository.save(bean);
        return bean.getCustomerId();
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    public void update(Integer id, CustomerUpdateVO vO) {
        Customer bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        customerRepository.save(bean);
    }

    public CustomerDTO getById(Integer id) {
        Customer original = requireOne(id);
        return toDTO(original);
    }

    public Page<CustomerDTO> query(CustomerQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CustomerDTO toDTO(Customer original) {
        CustomerDTO bean = new CustomerDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Customer requireOne(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
