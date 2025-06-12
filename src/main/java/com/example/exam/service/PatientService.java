package com.example.exam.service;

import com.example.exam.dto.PatientDTO;
import com.example.exam.dto.ReportPatientDTO;
import com.example.exam.model.Patient;
import com.example.exam.mapper.PatientMapper;
import com.example.exam.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private final PatientRepository repository;
    private final PatientMapper mapper;

    public PatientService(PatientRepository repository, PatientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PatientDTO> getAllPatients() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public PatientDTO getPatientById(Long id) {
        Optional<Patient> optional = repository.findById(id);
        return optional.map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    public ReportPatientDTO getReportById(Long id) {
        return repository.findById(id)
                .map(mapper::toReportDTO)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    public PatientDTO createPatient(PatientDTO dto) {
        Patient patient = mapper.fromDTO(dto);
        Patient saved = repository.save(patient);
        return mapper.toDTO(saved);
    }
}
