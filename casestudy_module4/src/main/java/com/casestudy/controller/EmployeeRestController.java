package com.casestudy.controller;

import com.casestudy.model.employee.Employee;
import com.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/restEmployee")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @PostMapping("/save")
    public String createEmployee(@RequestBody Employee employee){
        iEmployeeService.addNewEmployee(employee);
        return "redirect:/employee/list";
    }
}
