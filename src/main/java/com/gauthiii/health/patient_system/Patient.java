package com.gauthiii.health.patient_system;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "patients")
public class Patient {
    @Id
    private String id;
    private String email;
 
    private String name;
    private LocalDate birthDate;
    private String medicalHistory;
    private String contact;
    private String address;
    private String gender;
    private List<String> currentMedications;
    private List<String> allergies;
    private String height;
    private String weight;
    private String bmi;
    private String blood;
    private String primaryDiagnosis;
    private String insuranceProvider;
    private String insurancePolicyNumber;
    private String emergencyContactName;
    private String emergencyContactRelation;
    private String emergencyContactPhone;
    private List<String> appointments;
    private List<String> prescriptions;
    private List<String> bills;

    // Constructors, getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getCurrentMedications() {
        return currentMedications;
    }

    public void setCurrentMedications(List<String> currentMedications) {
        this.currentMedications = currentMedications;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getPrimaryDiagnosis() {
        return primaryDiagnosis;
    }

    public void setPrimaryDiagnosis(String primaryDiagnosis) {
        this.primaryDiagnosis = primaryDiagnosis;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactRelation() {
        return emergencyContactRelation;
    }

    public void setEmergencyContactRelation(String emergencyContactRelation) {
        this.emergencyContactRelation = emergencyContactRelation;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public List<String> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<String> appointments) {
        this.appointments = appointments;
    }

    public List<String> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<String> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<String> getBills() {
        return bills;
    }

    public void setBills(List<String> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", email=" + email +

                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", medicalHistory='" + medicalHistory + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", currentMedications=" + currentMedications +
                ", allergies=" + allergies +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", bmi='" + bmi + '\'' +
                ", blood='" + blood + '\'' +
                ", primaryDiagnosis='" + primaryDiagnosis + '\'' +
                ", insuranceProvider='" + insuranceProvider + '\'' +
                ", insurancePolicyNumber='" + insurancePolicyNumber + '\'' +
                ", emergencyContactName='" + emergencyContactName + '\'' +
                ", emergencyContactRelation='" + emergencyContactRelation + '\'' +
                ", emergencyContactPhone='" + emergencyContactPhone + '\'' +
                ", appointments=" + appointments +
                ", prescriptions=" + prescriptions +
                ", bills=" + bills +
                '}';
    }
}
