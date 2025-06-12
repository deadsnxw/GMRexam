package com.example.exam.controller;

import com.example.exam.dto.PatientDTO;
import com.example.exam.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping
    public List<PatientDTO> getAllPatients() {
        return service.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientDTO getPatient(@PathVariable Long id) {
        return service.getPatientById(id);
    }

    @PostMapping
    public PatientDTO createPatient(@RequestBody PatientDTO dto) {
        return service.createPatient(dto);
    }
}
