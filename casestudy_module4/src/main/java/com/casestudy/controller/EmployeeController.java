package com.casestudy.controller;

import com.casestudy.model.employee.Division;
import com.casestudy.model.employee.EducationDegree;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.employee.Position;
import com.casestudy.model.facility.Facility;
import com.casestudy.model.facility.FacilityType;
import com.casestudy.model.facility.RentType;
import com.casestudy.service.employee.IDivisionService;
import com.casestudy.service.employee.IEducationDegreeService;
import com.casestudy.service.employee.IEmployeeService;
import com.casestudy.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IPositionService iPositionService;

    @GetMapping("/list")
    public String showEmployeeList(@PageableDefault(value = 5, sort = "employee_name", direction = Sort.Direction.ASC) Pageable pageable,
                                   @RequestParam(value = "employeeName", defaultValue = "") String employeeName,
                                   @RequestParam(value = "employeeAddress", defaultValue = "") String employeeAddress,
                                   @RequestParam(value = "employeePhone", defaultValue = "") String employeePhone,
                                   Model model) {
        List<Division> divisions = iDivisionService.showListDivision();
        List<EducationDegree> educationDegrees = iEducationDegreeService.showListEducationDegree();
        List<Position> positions = iPositionService.showListPosition();
        Page<Employee> employees = iEmployeeService.search(pageable, employeeName, employeeAddress, employeePhone);
        model.addAttribute("divisions", divisions);
        model.addAttribute("educationDegrees", educationDegrees);
        model.addAttribute("positions", positions);
        model.addAttribute("employeeList", employees);
        model.addAttribute("employeeName", employeeName);
        model.addAttribute("employeeAddress", employeeAddress);
        model.addAttribute("employeePhone", employeePhone);
        return "employee/list";
    }
}
