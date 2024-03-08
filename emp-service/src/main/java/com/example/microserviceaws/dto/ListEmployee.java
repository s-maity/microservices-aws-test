package com.example.microserviceaws.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListEmployee {
    private List<Employee> employees;

    public static ListEmployee of(List<Employee> employees) {
        return new ListEmployee(employees);
    }
}
