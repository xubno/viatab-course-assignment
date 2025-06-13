package com.via.viatab.repository;

import com.via.viatab.entity.ClickCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickCounterRepository extends JpaRepository<ClickCounter, Long> {
    ClickCounter findByDepartment(String department);
}
