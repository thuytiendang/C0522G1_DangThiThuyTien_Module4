package com.casestudy.service.employee;

import com.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    Page<Employee> showListEmployee(Pageable pageable);

    void addNewEmployee(Employee employee);

    void deleteLogical(Integer id);

    void updateEmployee(Employee employee);

    Employee findById(int id);

    Page<Employee> search(Pageable pageable, String employeeName, String employeeAddress, String employeePhone);
}
