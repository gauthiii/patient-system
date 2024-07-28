package com.gauthiii.health.patient_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users") // Base path for all methods in this controller
@CrossOrigin(origins = {"http://localhost:3000","https://localhost:3000" })
public class UserController {
    @Autowired
    private UserService service;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return service.findAll();
    }

    // Create a new user
    @PostMapping // No need to specify "/patients" since it's already specified in @RequestMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User savedUser = service.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception details to help diagnose the issue
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user: " + e.getMessage());
        }
    }

    // Get a user by ID
    @GetMapping("/id")
    public ResponseEntity<?> getUserById(@RequestHeader("Authorization-ID") String id) {
        User user = service.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
        }
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {

        User user = service.findById(id);
        if (user != null) {
            try {
                service.deleteById(id);
                return ResponseEntity.ok().body("User deleted successfully.");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to delete. User not found with ID: " + id);
        }

      
    }


     // Partial update a user by ID
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody Map<String, Object> updates) {
        User user = service.findById(id);
        if (user != null) {
            updates.forEach((key, value) -> {
                switch (key) {
                    case "name":
                        user.setName((String) value);
                        break;
                    case "email":
                    user.setEmail((String) value);
                    break;
                    case "role":
                    user.setRole((String) value);
                    break;
                    case "password":
                    user.setPassword((String) value);
                    case "requests":
                        List<String> currentRequests = user.getRequests();
                        if (currentRequests != null) {
                            if (!currentRequests.contains((String) value)) {
                            currentRequests.add((String) value);
                            }
                        } else {
                            currentRequests = new ArrayList<>();
                            currentRequests.add((String) value);
                        }
                        user.setRequests(currentRequests);
                    break;
                    case "removeRequest":
                        List<String> requests = user.getRequests();
                        if (requests != null && requests.contains((String) value)) {
                            requests.remove(value);
                        }
                        user.setRequests(requests);
                        break;
                    
                }
            });
            User updatedUser = service.save(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
        }
    }



     
}
// /Users/gauthamsmacbook/Apps/Springboot Apps/patient-system