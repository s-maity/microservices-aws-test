package com.example.microserviceaws.service;

import com.example.microserviceaws.dto.Career;
import com.example.microserviceaws.dto.CreateEmployeeRequest;
import com.example.microserviceaws.dto.Employee;
import com.example.microserviceaws.entity.EmployeeEntity;
import com.example.microserviceaws.repository.EmpJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmpJPARepository empJPARepository;

    @Value("${app.emp_career_service_url}")
    private String empCareeerServiceURL;

    public List<Employee> getAllEmployee() {
        var employees = empJPARepository.findAll();
        return employees.stream()
                .map(emp -> build(emp, fethCareerDetails(emp.getId())))
                .toList();
    }

    private Career fethCareerDetails(int empId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(empCareeerServiceURL + "/" + empId, Career.class);
    }

    public int createEmployee(CreateEmployeeRequest request) {
        var newEmp = EmployeeEntity.builder()
                .name(request.name())
                .gender(request.gender())
                .build();
        return empJPARepository.save(newEmp)
                .getId();
    }

    private Employee build(EmployeeEntity e, Career career) {
        return Employee.builder()
                .id(e.getId())
                .name(e.getName())
                .gender(e.getGender())
                .skills(career.getSkills())
                .build();
    }
}
