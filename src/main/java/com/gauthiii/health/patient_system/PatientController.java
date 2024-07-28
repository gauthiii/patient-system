package com.gauthiii.health.patient_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patients") // Base path for all methods in this controller
@CrossOrigin(origins = {"http://localhost:3000","https://localhost:3000" })
public class PatientController {
    @Autowired
    private PatientService service;

    // Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return service.findAll();
    }

    // Create a new patient
    @PostMapping // No need to specify "/patients" since it's already specified in @RequestMapping
    public ResponseEntity<?> createPatient(@RequestBody Patient patient) {
        try {
            Patient savedPatient = service.save(patient);
            return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception details to help diagnose the issue
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating patient: " + e.getMessage());
        }
    }

    // Get a patient by ID
    @GetMapping("/id")
    public ResponseEntity<?> getPatientById(@RequestHeader("Authorization-ID") String id) {
        Patient patient = service.findById(id);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found with ID: " + id);
        }
    }

    // Delete a patient by ID
    @DeleteMapping("/id")
    public ResponseEntity<?> deletePatient(@RequestHeader("Authorization-ID") String id) {

        Patient patient = service.findById(id);
        if (patient != null) {
            try {
                service.deleteById(id);
                return ResponseEntity.ok().body("Patient deleted successfully.");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting patient: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to delete. Patient not found with ID: " + id);
        }

      
    }


     // Partial update a patient by ID
    @SuppressWarnings("unchecked")
    @PatchMapping("/id")
    public ResponseEntity<?> updatePatient(@RequestHeader("Authorization-ID") String id, @RequestBody Map<String, Object> updates) {
        Patient patient = service.findById(id);
        if (patient != null) {
            updates.forEach((key, value) -> {
                switch (key) {
                    case "name":
                        patient.setName((String) value);
                        break;
                    case "email":
                    patient.setEmail((String) value);
                    break;
                    case "birthDate":
                        patient.setBirthDate(LocalDate.parse((String) value));
                        break;
                    case "medicalHistory":
                        patient.setMedicalHistory((String) value);
                        break;
                    case "contact":
                        patient.setContact((String) value);
                        break;
                    case "address":
                        patient.setAddress((String) value);
                        break;
                    case "gender":
                        patient.setGender((String) value);
                        break;
                    case "currentMedications":
                        patient.setCurrentMedications((List<String>) value);
                        break;
                    case "allergies":
                        patient.setAllergies((List<String>) value);
                        break;
                    case "height":
                        patient.setHeight((String) value);
                        break;
                    case "weight":
                        patient.setWeight((String) value);
                        break;
                    case "bmi":
                        patient.setBmi((String) value);
                        break;
                    case "blood":
                        patient.setBlood((String) value);
                        break;
                    case "primaryDiagnosis":
                        patient.setPrimaryDiagnosis((String) value);
                        break;
                    case "insuranceProvider":
                        patient.setInsuranceProvider((String) value);
                        break;
                    case "insurancePolicyNumber":
                        patient.setInsurancePolicyNumber((String) value);
                        break;
                    case "emergencyContactName":
                        patient.setEmergencyContactName((String) value);
                        break;
                    case "emergencyContactRelation":
                        patient.setEmergencyContactRelation((String) value);
                        break;
                    case "emergencyContactPhone":
                        patient.setEmergencyContactPhone((String) value);
                        break;
                    case "appointments":
                        patient.setAppointments((List<String>) value);
                        break;
                    case "prescriptions":
                        patient.setPrescriptions((List<String>) value);
                        break;
                    case "bills":
                        patient.setBills((List<String>) value);
                        break;
                }
            });
            Patient updatedPatient = service.save(patient);
            return ResponseEntity.ok(updatedPatient);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found with ID: " + id);
        }
    }


    // // New API to check the authToken
    // @GetMapping("/check-token")
    // public ResponseEntity<?> checkAuthToken(@RequestParam("token") String token) {
    //     List<Patient> patients = service.findAll();
    //     for (Patient patient : patients) {
    //         if (token.equals(patient.getAuthToken())) {
    //             return ResponseEntity.ok(patient.getId());
    //         }
    //     }
    //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No patient found with the provided auth token");
    // }


    // New API to check the authToken
    @GetMapping("/check-email")
public ResponseEntity<?> checkAuthToken(@RequestHeader("Authorization-Email") String email) {
    List<Patient> patients = service.findAll();
    for (Patient patient : patients) {
        if (email.equals(patient.getEmail())) {
            return ResponseEntity.ok(patient.getId());
        }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No patient found with the provided auth token");
}

     
}
// /Users/gauthamsmacbook/Apps/Springboot Apps/patient-system