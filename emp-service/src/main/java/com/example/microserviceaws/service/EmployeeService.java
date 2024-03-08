package com.example.microserviceaws.service;

import com.example.microserviceaws.dto.CreateEmployeeRequest;
import com.example.microserviceaws.dto.Employee;
import com.example.microserviceaws.entity.EmployeeEntity;
import com.example.microserviceaws.repository.EmpJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmpJPARepository empJPARepository;

    public List<Employee> getAllEmployee() {
        return map(empJPARepository.findAll());
    }

    public int createEmployee(CreateEmployeeRequest request) {
        var newEmp = EmployeeEntity.builder()
                .name(request.name())
                .gender(request.gender())
                .build();
        return empJPARepository.save(newEmp)
                .getId();
    }

    private List<Employee> map(List<EmployeeEntity> entities) {
        return entities.stream()
                .map(this::buildEmployees)
                .toList();
    }

    private Employee buildEmployees(EmployeeEntity e) {
        return Employee.builder()
                .id(e.getId())
                .name(e.getName())
                .gender(e.getGender())
                .build();
    }
}
