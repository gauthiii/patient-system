package com.gauthiii.health.patient_system;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// import java.time.LocalDate;
// import java.util.List;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String email;
    private String name;
    private String password;
    private String role;
    private List<String> requests;
    

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getRequests() {
        return requests;
    }

    public void setRequests(List<String> requests) {
        this.requests = requests;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                "email=" + email +

                ", name='" + name + '\'' +

                ", password='" + password + '\'' +

                ", role='" + role + '\'' +

                ", requests='" + requests + '\'' +
            
                '}';
    }
}
