package com.calculator.controller;

import com.calculator.service.ICalculatorService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String showCalculator() {
        return "calculator";
    }

    @RequestMapping("/calculate")
    public ModelAndView calculator(@RequestParam String number1, String number2, String calculator) {
        return new ModelAndView("calculator", "result", iCalculatorService.calculate(number1, number2, calculator));
    }
}
