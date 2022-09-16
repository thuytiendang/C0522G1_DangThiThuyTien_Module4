package com.vlog.controller;

import com.vlog.model.Vlog;
import com.vlog.service.IVlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class VlogController {

    @Autowired
    private IVlogService iVlogService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Vlog> vlogList = iVlogService.findAll();
        model.addAttribute("vlogList", vlogList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("vlog", new Vlog());
        return "create";
    }

    @PostMapping("/save")
    public String save(Vlog vlog, RedirectAttributes redirectAttributes) {
        iVlogService.save(vlog);
        redirectAttributes.addFlashAttribute("mess", "Add new vlog successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("vlog", iVlogService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Vlog vlog, RedirectAttributes redirectAttributes) {
        iVlogService.update(vlog);
        redirectAttributes.addFlashAttribute("mess", "Update vlog successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("vlog", iVlogService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Vlog vlog, RedirectAttributes redirectAttributes) {
        iVlogService.delete(vlog.getId());
        redirectAttributes.addFlashAttribute("mess", "Delete vlog successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("vlog", iVlogService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String title, Model model) {
        model.addAttribute("vlogList", iVlogService.findByTitleContaining(title));
        return "list";
    }
}
