package com.example.exam.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDTO {
    private String name;
    private String diagnosis;
}
