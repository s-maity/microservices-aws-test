package com.example.microserviceaws.controller;

import com.example.microserviceaws.dto.CreateEmpResponse;
import com.example.microserviceaws.dto.CreateEmployeeRequest;
import com.example.microserviceaws.dto.ListEmployee;
import com.example.microserviceaws.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmpController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<ListEmployee> getAllEmployee() {
        return new ResponseEntity<>(ListEmployee.of(employeeService.getAllEmployee()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateEmpResponse> getAllEmployee(@RequestBody CreateEmployeeRequest request) {
        return new ResponseEntity<>(new CreateEmpResponse(employeeService.createEmployee(request)), HttpStatus.CREATED);
    }


}
