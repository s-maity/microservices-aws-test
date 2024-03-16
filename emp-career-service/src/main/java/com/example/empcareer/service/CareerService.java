package com.example.empcareer.service;

import com.example.empcareer.dto.Career;
import com.example.empcareer.dto.CreateCareerRequest;
import com.example.empcareer.entity.CareerEntity;
import com.example.empcareer.repository.CareerJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CareerService {
    private final CareerJPARepository careerJPARepository;

    public Career getCareerByEmpId(int id) {
        return buildCareer(careerJPARepository.findByEmpId(id)
                .orElseThrow(() -> new RuntimeException("Data not found")));
    }

    public int insertOrUpdateCareer(CreateCareerRequest request) {
        var exisitingCareer = careerJPARepository.findByEmpId(request.empId());

        var newCareer = CareerEntity.builder()
                .empId(request.empId())
                .skills(request.skills())
                .build();
        exisitingCareer.ifPresent(e -> newCareer.setId(e.getId()));
        return careerJPARepository.save(newCareer)
                .getId();
    }

    private Career buildCareer(CareerEntity e) {
        return Career.builder()
                .id(e.getId())
                .empId(e.getEmpId())
                .skills(e.getSkills())
                .build();
    }
}
