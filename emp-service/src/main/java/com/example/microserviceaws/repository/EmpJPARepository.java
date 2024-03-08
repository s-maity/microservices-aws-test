package com.example.microserviceaws.repository;

import com.example.microserviceaws.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpJPARepository extends JpaRepository<EmployeeEntity,Integer> {
}
