package com.casestudy.service.employee.impl;

import com.casestudy.model.employee.Employee;
import com.casestudy.repository.employee.IEmployeeRepository;
import com.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;


    @Override
    public List<Employee> showListEmployee() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void addNewEmployee(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void deleteLogical(Integer id) {
        iEmployeeRepository.deleteLogical(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> search(Pageable pageable, String employeeName, String employeeAddress, String employeePhone) {
        return iEmployeeRepository.search(pageable, employeeName, employeeAddress, employeePhone);
    }
}
