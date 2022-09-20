package com.validation.controller;

import com.validation.dto.UserDto;
import com.validation.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/user")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "index";
    }

    @PostMapping("/validateUser")
    public String checkValidation(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "index";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return"result";
    }
}
