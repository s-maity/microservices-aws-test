package com.example.microserviceaws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {

    private int id;
    private String name;
    private String gender;
    private List<String> skills;
}
