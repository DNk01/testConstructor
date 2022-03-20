package com.example.testconstructor.controllers;

import com.example.testconstructor.entities.Constructor;
import com.example.testconstructor.services.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controllers")
public class ConstructorController {
    private final ConstructorService constructorService;

    @Autowired
    public ConstructorController(ConstructorService constructorService) {
        this.constructorService = constructorService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createConstructor(@RequestBody Constructor constructor) {
        constructorService.createConstructor(constructor);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    ResponseEntity<Constructor> findConstructor(@PathVariable("id") Long id) {
        return ResponseEntity.ok(constructorService.findByIdConstructor(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteConstructor(@PathVariable("id") Long id){
        constructorService.deleteByIdConstructor(id);
    }

}
