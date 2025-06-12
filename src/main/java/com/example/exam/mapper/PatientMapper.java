package com.example.exam.mapper;

import com.example.exam.dto.PatientDTO;
import com.example.exam.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
    public PatientDTO toDTO(Patient patient) {
        return PatientDTO.builder()
                .name(patient.getName())
                .diagnosis(patient.getDiagnosis())
                .build();
    }

    public Patient fromDTO(PatientDTO dto) {
        return Patient.builder()
                .name(dto.getName())
                .diagnosis(dto.getDiagnosis())
                .build();
    }
}
