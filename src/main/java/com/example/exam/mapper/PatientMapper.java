package com.example.exam.mapper;

import com.example.exam.dto.PatientDTO;
import com.example.exam.dto.ReportPatientDTO;
import com.example.exam.model.Patient;
import org.mapstruct.factory.Mappers;
import org.mapstruct.*;

import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDTO toPatientDTO(Patient patient); // Entity to DTO

    Patient toPatient(PatientDTO dto); // DTO to Entity

    // mapping for ReportPatientDTO
    @Mapping(target = "createdAt", expression = "java(formatDate(patient.getCreatedAt()))")
    ReportPatientDTO toReportDTO(Patient patient);

    default String formatDate(java.time.LocalDateTime dateTime) {
        if (dateTime == null) return null;
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
