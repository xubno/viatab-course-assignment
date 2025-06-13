package com.via.viatab.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "click_counter")
public class ClickCounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "count_value")
    private Long countValue;
    
    @Column(name = "department")
    private String department;
    
    // Constructors
    public ClickCounter() {}
    
    public ClickCounter(String department, Long countValue) {
        this.department = department;
        this.countValue = countValue;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getCountValue() { return countValue; }
    public void setCountValue(Long countValue) { this.countValue = countValue; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
