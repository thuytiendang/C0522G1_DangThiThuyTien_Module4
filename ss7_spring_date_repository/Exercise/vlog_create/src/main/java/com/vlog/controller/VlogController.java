package com.vlog.controller;

import com.vlog.model.Vlog;
import com.vlog.service.ICategoryService;
import com.vlog.service.IVlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VlogController {

    @Autowired
    private IVlogService iVlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/")
    public String showList(@PageableDefault(value = 3, sort = "createdDate", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        Page<Vlog> vlogList = iVlogService.findAll(pageable);
        model.addAttribute("vlogList", vlogList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("vlog", new Vlog());
        model.addAttribute("category", iCategoryService.findAll());
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
        model.addAttribute("category", iCategoryService.findAll());

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
        model.addAttribute("category", iCategoryService.findAll());
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
        model.addAttribute("category", iCategoryService.findAll());
        return "/view";
    }

    @GetMapping("/search")
    public String search(@PageableDefault(value = 3, sort = "createdDate", direction = Sort.Direction.ASC) Pageable pageable,
                         @RequestParam String title, Model model) {
        model.addAttribute("vlogList", iVlogService.findByTitleContaining(title, pageable));
        return "list";
    }
}
