package com.validation.controller;

import com.validation.dto.PhoneDto;
import com.validation.model.Phone;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("phoneDto", new PhoneDto());
        return "/index";
    }
    @PostMapping("/save")
    public String checkValidation (@Valid @ModelAttribute("phoneDto")PhoneDto phoneDto, BindingResult bindingResult, Model model){
        new PhoneDto().validate(phoneDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/index";
        }
        else {
            Phone phone = new Phone();
            BeanUtils.copyProperties(phoneDto, phone);
            model.addAttribute("phone", phone);
            return "/result";
        }
    }
}
