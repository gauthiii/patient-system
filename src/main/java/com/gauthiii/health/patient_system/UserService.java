package com.gauthiii.health.patient_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}