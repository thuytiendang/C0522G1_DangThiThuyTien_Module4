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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                                   Model model) {
        List<CustomerType> customerTypes = iCustomerTypeService.showListTypeCustomer();
        Page<Customer> customers = iCustomerService.search(pageable, nameSearch, addressSearch, phoneSearch);
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("addressSearch", addressSearch);
        model.addAttribute("phoneSearch", phoneSearch);
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customerList", customers);
        return "customer/list";
    }

    @GetMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("customerTypes", iCustomerTypeService.showListTypeCustomer());
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/add")
    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.addNewCustomer(customer);
        redirectAttributes.addFlashAttribute("mess", "Add new customer successfully!");
        return "redirect:/customer/list";
    }

    @GetMapping("/edit/{id}")
    public String edit (@PathVariable int id, Model model){
        model.addAttribute("customerTypes", iCustomerTypeService.showListTypeCustomer());
        model.addAttribute("customer", iCustomerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes){
        iCustomerService.updateCustomer(customer);
        redirectAttributes.addFlashAttribute("mess", "Update customer successfully!");
        return "redirect:/customer/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
        iCustomerService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("mess", "Delete customer successfully!");
        return "redirect:/customer/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id){
        iCustomerService.findById(id);
        return "redirect:/customer/list";
    }
}
