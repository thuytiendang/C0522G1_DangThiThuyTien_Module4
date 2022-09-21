package com.validate.controller;

import com.validate.dto.UserDto;
import com.validate.model.User;
import com.validate.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String showList( Model model){
        List<User> userList = iUserService.findAll();
        model.addAttribute("userList",userList);
        return "list";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("userDto", new UserDto());
        return "/index";
    }
    @PostMapping("/save")
    public String checkValidation (@Valid @ModelAttribute("userDto")UserDto userDto, BindingResult bindingResult, Model model){
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/index";
        }
        else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            model.addAttribute("user", user);
            return "/result";
        }
    }
}
