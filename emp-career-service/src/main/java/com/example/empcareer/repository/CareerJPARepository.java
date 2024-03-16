package com.example.empcareer.repository;

import com.example.empcareer.entity.CareerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CareerJPARepository extends JpaRepository<CareerEntity, Integer> {
    Optional<CareerEntity> findByEmpId(int id);
}
