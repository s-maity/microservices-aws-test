package com.example.empcareer.controller;

import com.example.empcareer.dto.Career;
import com.example.empcareer.dto.CreateEmpResponse;
import com.example.empcareer.dto.CreateCareerRequest;
import com.example.empcareer.service.CareerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/career")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CareerController {

    private final CareerService careerService;

    @GetMapping("/{empId}")
    public ResponseEntity<Career> getCareerByEmp(@PathVariable("empId") int empId) {
        return new ResponseEntity<>(careerService.getCareerByEmpId(empId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateEmpResponse> insertEmpCareer(@RequestBody CreateCareerRequest request) {
        return new ResponseEntity<>(new CreateEmpResponse(careerService.insertOrUpdateCareer(request)), HttpStatus.CREATED);
    }
}
