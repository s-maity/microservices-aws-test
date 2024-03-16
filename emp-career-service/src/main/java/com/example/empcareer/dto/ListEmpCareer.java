package com.example.empcareer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListEmpCareer {
    private List<Career> careerData;

    public static ListEmpCareer of(List<Career> careers) {
        return new ListEmpCareer(careers);
    }
}
