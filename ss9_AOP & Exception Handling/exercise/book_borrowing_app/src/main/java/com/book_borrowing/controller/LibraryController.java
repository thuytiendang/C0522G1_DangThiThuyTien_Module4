package com.book_borrowing.controller;

import com.book_borrowing.model.Library;
import com.book_borrowing.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LibraryController {

    @Autowired
    private ILibraryService iLibraryService;

    @RequestMapping("/")
    public String showList(Model model) {
        model.addAttribute("library", iLibraryService.findAll());
        return "list";
    }

    @GetMapping("/{id}/borrow")
    public String saveBorrow(@PathVariable int id, Model model) throws Exception {
        Library library = iLibraryService.findById(id).get();
        if (library == null) {
            throw new Exception();
        }
        if (library.getNumberOfBook() == 0) {
            model.addAttribute("mess", "Out of books!");
            model.addAttribute("library", iLibraryService.findAll());
            return "list";
        }
        library.setNumberOfBook(library.getNumberOfBook() - 1);
        iLibraryService.update(library);
        model.addAttribute("library", iLibraryService.findAll());
        model.addAttribute("mess", "borrowed successfully! your book code is: " + library.getCode());
        return "list";
    }

    @GetMapping("/pay")
    public String pay() {
        return "pay";
    }

    @PostMapping("/paySave")
    public String savePay(@RequestParam String code, Model model) throws Exception {
        Library library = iLibraryService.findByCode(code);
        if (library == null) {
            model.addAttribute("mess", "Code incorrect!");
            return "pay";
        }
        if (library.getNumberOfBook() == library.getStatus()) {
            model.addAttribute("mess", "book is full!");
            return "pay";
        }
        library.setNumberOfBook(library.getNumberOfBook() + 1);
        iLibraryService.update(library);
        model.addAttribute("mess", "Pay book successfully!");
        return "redirect:/";
    }

    @ExceptionHandler(value = Exception.class)
    public String error() {
        return "error";
    }
}
