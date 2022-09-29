package com.vlog.controller;

import com.vlog.model.Vlog;
import com.vlog.service.ICategoryService;
import com.vlog.service.IVlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/vlog")
public class VlogController {

    @Autowired
    private IVlogService iVlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<List<Vlog>> getVlogList(){
        List<Vlog> vlogList = iVlogService.showVlogList();
        if (vlogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vlogList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vlog> view(@PathVariable int id) {
       Vlog currentVlog = iVlogService.findById(id);
       if (currentVlog == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(currentVlog, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Vlog>> getListOfCategory(@PathVariable int id){
        List<Vlog> vlogList = iVlogService.showListOfCategory(id);
        if (vlogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vlogList,HttpStatus.OK);
    }

}
