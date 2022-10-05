package com.casestudy.controller;

import com.casestudy.model.employee.Division;
import com.casestudy.model.employee.EducationDegree;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.employee.Position;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
//@CrossOrigin
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
        model.addAttribute("employee", new Employee());
        return "employee/list";
    }

    @GetMapping("/delete")
    public String deleteFacility(@RequestParam int id, RedirectAttributes redirectAttributes){
        iEmployeeService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("mess", "Delete employee successfully!");
        return "redirect:/employee/list";
    }

    @GetMapping("/view")
    public String viewFacility(@RequestParam int id){
        iEmployeeService.findById(id);
        return "redirect:/employee/list";
    }
}
