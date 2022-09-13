package com.medicalDeclaration.controller;

import com.medicalDeclaration.model.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalDeclarationController {

    @GetMapping("/")
    public String showForm(ModelMap model){
        model.addAttribute("medicalDeclaration", new MedicalDeclaration());
        return "create";
    }

    @PostMapping("/addMedicalDeclaration")
    public String create(@ModelAttribute MedicalDeclaration medicalDeclaration, Model model){
        model.addAttribute("medicalDeclaration", medicalDeclaration);

        return "info";
    }
}
