package com.zjh.sample.service;

import com.zjh.sample.dto.EmployeeDTO;
import com.zjh.sample.entity.Employee;
import com.zjh.sample.repository.EmployeeRepository;
import com.zjh.sample.vo.EmployeeQueryVO;
import com.zjh.sample.vo.EmployeeUpdateVO;
import com.zjh.sample.vo.EmployeeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Integer save(EmployeeVO vO) {
        Employee bean = new Employee();
        BeanUtils.copyProperties(vO, bean);
        bean = employeeRepository.save(bean);
        return bean.getEmployeeId();
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    public void update(Integer id, EmployeeUpdateVO vO) {
        Employee bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        employeeRepository.save(bean);
    }

    public EmployeeDTO getById(Integer id) {
        Employee original = requireOne(id);
        return toDTO(original);
    }

    public Page<EmployeeDTO> query(EmployeeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private EmployeeDTO toDTO(Employee original) {
        EmployeeDTO bean = new EmployeeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Employee requireOne(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
