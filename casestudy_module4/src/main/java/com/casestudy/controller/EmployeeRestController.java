package com.casestudy.controller;

import com.casestudy.model.employee.Employee;
import com.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/restEmployee")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @PostMapping(value = "/save")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        iEmployeeService.addNewEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getPhoneById(@PathVariable int id){
       Optional<Employee> employee = Optional.ofNullable(iEmployeeService.findById(id));
        if (!employee.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Employee employee){
        iEmployeeService.updateEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
