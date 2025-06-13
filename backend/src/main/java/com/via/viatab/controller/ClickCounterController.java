package com.via.viatab.controller;

import com.via.viatab.entity.ClickCounter;
import com.via.viatab.service.ClickCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clicks")
@CrossOrigin(origins = "*")
public class ClickCounterController {
    
    @Autowired
    private ClickCounterService service;
    
    @PostMapping("/increment/{department}")
    public ClickCounter incrementClick(@PathVariable String department) {
        return service.incrementCounter(department);
    }
    
    @GetMapping("/{department}")
    public ClickCounter getClickCount(@PathVariable String department) {
        return service.getCounter(department);
    }
}
