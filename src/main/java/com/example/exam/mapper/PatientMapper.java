package com.example.exam.mapper;

import com.example.exam.dto.PatientDTO;
import com.example.exam.dto.ReportPatientDTO;
import com.example.exam.model.Patient;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class PatientMapper {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public PatientDTO toDTO(Patient patient) {
        return PatientDTO.builder()
                .name(patient.getName())
                .diagnosis(patient.getDiagnosis())
                .build();
    }

    public ReportPatientDTO toReportDTO(Patient patient) {
        return ReportPatientDTO.builder()
                .name(patient.getName())
                .diagnosis(patient.getDiagnosis())
                .createdAt(patient.getCreatedAt().format(FORMATTER))
                .build();
    }

    public Patient fromDTO(PatientDTO dto) {
        return Patient.builder()
                .name(dto.getName())
                .diagnosis(dto.getDiagnosis())
                .build();
    }
}
