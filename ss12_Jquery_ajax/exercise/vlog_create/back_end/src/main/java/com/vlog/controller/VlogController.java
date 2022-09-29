package com.vlog.controller;

import com.vlog.model.Vlog;
import com.vlog.service.ICategoryService;
import com.vlog.service.IVlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
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

    @GetMapping("/search")
    public ResponseEntity<List<Vlog>> search(Optional<String> title){
        System.out.println(title);
        String str = title.orElse("");
        System.out.println(str);
        List<Vlog> vlogList = iVlogService.findByTitleContaining(str);
        System.out.println(vlogList.size());

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
