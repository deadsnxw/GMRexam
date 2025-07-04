package com.example.exam.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDTO { // DTO for creating a patient and getting basic information
    private String name;
    private String diagnosis;
}
