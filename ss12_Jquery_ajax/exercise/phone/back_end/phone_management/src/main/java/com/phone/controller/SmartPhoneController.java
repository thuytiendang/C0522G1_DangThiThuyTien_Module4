package com.phone.controller;

import com.phone.model.SmartPhone;
import com.phone.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/smartphones")
public class SmartPhoneController {

    @Autowired
    private ISmartPhoneService iSmartPhoneService;

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> getAllSmartPhoneList(){
        return new ResponseEntity<>(iSmartPhoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SmartPhone> delete(@PathVariable Long id){
        Optional<SmartPhone> smartPhone = iSmartPhoneService.findById(id);
        if (!smartPhone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iSmartPhoneService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SmartPhone> create(@RequestBody SmartPhone smartPhone){
        iSmartPhoneService.save(smartPhone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SmartPhone> getPhoneById(Long id){
       Optional<SmartPhone> smartPhone = iSmartPhoneService.findById(id);
        if (!smartPhone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartPhone.get(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SmartPhone> update(SmartPhone smartPhone){
        iSmartPhoneService.update(smartPhone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
