package com.gauthiii.health.patient_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public List<Patient> findAll() {
        return repository.findAll();
    }

    public Patient save(Patient patient) {
        return repository.save(patient);
    }

    public Patient findById(String id) {
        Optional<Patient> patient = repository.findById(id);
        return patient.orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
