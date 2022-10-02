package com.casestudy.controller;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.customer.CustomerType;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.customer.ICustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/list")
    public String showCustomerList(@PageableDefault(value = 5, sort = "customer_name", direction = Sort.Direction.ASC) Pageable pageable,
                                   @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                   @RequestParam(value = "addressSearch", defaultValue = "") String addressSearch,
                                   @RequestParam(value = "phoneSearch", defaultValue = "") String phoneSearch,
                                   Model model){
        List<CustomerType> customerTypes = iCustomerTypeService.showListTypeCustomer();
        Page<Customer> customers = iCustomerService.search(nameSearch, addressSearch, phoneSearch, pageable);
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("addressSearch", addressSearch);
        model.addAttribute("phoneSearch", phoneSearch);
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customerList", customers);
        return "customer/list";
    }
}
