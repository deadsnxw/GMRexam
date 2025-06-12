package com.example.exam.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportPatientDTO { // DTO for all information about a patient
    private String name;
    private String diagnosis;
    private String createdAt;
}
