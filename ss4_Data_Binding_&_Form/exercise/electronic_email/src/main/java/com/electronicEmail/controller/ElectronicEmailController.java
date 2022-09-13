package com.electronicEmail.controller;

import com.electronicEmail.model.ElectronicEmail;
import com.electronicEmail.service.IElectronicEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ElectronicEmailController {

    @Autowired
    private IElectronicEmailService iElectronicEmailService;

    @GetMapping("/")
    public String showElectronicEmail(ModelMap modelMap) {
        List<ElectronicEmail> electronicEmailList = iElectronicEmailService.showList();
        modelMap.addAttribute("electronicEmailList", electronicEmailList);
        return "list";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {
        model.addAttribute("electronicEmail", iElectronicEmailService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute ElectronicEmail electronicEmail, RedirectAttributes redirectAttributes) {
        iElectronicEmailService.update(electronicEmail);
        redirectAttributes.addFlashAttribute("mess", "electronicEmail" + " Update successful");
        return "redirect:/";
    }
}
