package com.via.viatab.service;

import com.via.viatab.entity.ClickCounter;
import com.via.viatab.repository.ClickCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClickCounterService {
    
    @Autowired
    private ClickCounterRepository repository;
    
    public ClickCounter incrementCounter(String department) {
        ClickCounter counter = repository.findByDepartment(department);
        if (counter == null) {
            counter = new ClickCounter(department, 1L);
        } else {
            counter.setCountValue(counter.getCountValue() + 1);
        }
        return repository.save(counter);
    }
    
    public ClickCounter getCounter(String department) {
        ClickCounter counter = repository.findByDepartment(department);
        return counter != null ? counter : new ClickCounter(department, 0L);
    }
}
