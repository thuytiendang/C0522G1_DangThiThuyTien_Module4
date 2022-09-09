package com.dictionary.controller;

import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/")
    public String showForm() {
        return "dictionary";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String word){
        return new ModelAndView("dictionary", "result", iDictionaryService.search(word));
    }

}
