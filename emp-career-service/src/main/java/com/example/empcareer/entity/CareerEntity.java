package com.example.empcareer.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "t_career")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CareerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int empId;
    private List<String> skills;
}
