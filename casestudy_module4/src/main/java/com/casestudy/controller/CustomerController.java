package com.casestudy.controller;

import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping
    public String showCustomerList(@PageableDefault(value = 5, sort = "customer_name", direction = Sort.Direction.ASC) Pageable pageable,
                                   @RequestParam(defaultValue = "") String name,
                                   @RequestParam(defaultValue = "") String address,
                                   @RequestParam(defaultValue = "") String phone, Model model){
        model.addAttribute("customerList", iCustomerService.search(name, address, phone, pageable));
        model.addAttribute("customerTypeList", iCustomerTypeService.showListTypeCustomer());
        model.addAttribute("searchName", name);
        model.addAttribute("searchAddress", address);
        model.addAttribute("searchPhone", phone);

        return "customer/list";
    }
}
