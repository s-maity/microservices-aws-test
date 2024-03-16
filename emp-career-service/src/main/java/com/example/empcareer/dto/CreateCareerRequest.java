package com.example.empcareer.dto;

import java.util.List;

public record CreateCareerRequest(int empId, List<String> skills) {
}
