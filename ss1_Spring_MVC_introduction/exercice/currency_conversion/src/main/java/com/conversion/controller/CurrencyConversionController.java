package com.conversion.controller;

import com.conversion.service.ICurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyConversionController {
    @Autowired
    private ICurrencyConversionService iCurrencyConversionService;
    @GetMapping("/")
    public String showList(){
        return "list";
    }

    @GetMapping("/exchange")
    public ModelAndView search(@RequestParam double money){
        return new ModelAndView("list", "result", iCurrencyConversionService.calculate(money));
    }
}
