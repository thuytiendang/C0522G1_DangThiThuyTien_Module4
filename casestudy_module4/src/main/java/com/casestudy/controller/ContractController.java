package com.casestudy.controller;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.contract.ContractDetail;
import com.casestudy.service.contract.IAttachFacilityService;
import com.casestudy.service.contract.IContractDetailService;
import com.casestudy.service.contract.IContractService;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.employee.IEmployeeService;
import com.casestudy.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/list")
    public String showList(Model model, Pageable pageable) {
        List<Contract> contractList = iContractService.findAll();
        model.addAttribute("contractList", iContractService.findAllDto());
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
        model.addAttribute("contractDetailList", iContractDetailService.findAll());
        model.addAttribute("facilityList", iFacilityService.showListFacility(pageable));
        model.addAttribute("employeeList", iEmployeeService.showListEmployee(pageable));
        model.addAttribute("customerList", iCustomerService.showCustomerList(pageable));
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetail", new ContractDetail());

        LocalDate minAge = LocalDate.now();
        model.addAttribute("minAge", minAge);

        return "contract/list";
    }
}
