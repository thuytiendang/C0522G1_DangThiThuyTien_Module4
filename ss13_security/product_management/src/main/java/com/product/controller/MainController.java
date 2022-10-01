package com.product.controller;

import com.product.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/login")
    public String showLoginPage(){
        return "myLogin";
    }

}
