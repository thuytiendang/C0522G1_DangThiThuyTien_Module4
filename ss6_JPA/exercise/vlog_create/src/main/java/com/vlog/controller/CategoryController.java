package com.vlog.controller;

import com.vlog.model.Category;
import com.vlog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showList( Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "category/category_list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/category_create";
    }

    @PostMapping("/save")
    public String save(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("mess", "Add new category successfully!");
        return "redirect:/category";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/category_edit";
    }

    @PostMapping("/update")
    public String update(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.update(category);
        redirectAttributes.addFlashAttribute("mess", "Update category successfully!");
        return "redirect:/category";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/category_delete";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.delete(category.getId());
        redirectAttributes.addFlashAttribute("mess", "Delete category successfully!");
        return "redirect:/category";
    }

}
